(ns project-euler.prob024
  (:require [project-euler.utils :as u]
            [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-1: compute all permutations => too costly, does not finish :(
(def numbers [0 1 2 3 4 5 6 7 8 9])

(defn perms [arr]
  (map (comp str/join #(map str %)) (combo/permutations arr)))

(defn main-1 [arr n]
  (first (drop (dec n) (take n (perms arr)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-2: http://www.mathblog.dk/project-euler-24-millionth-lexicographic-permutation/

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-3:
;; http://www.mathblog.dk/project-euler-24-millionth-lexicographic-permutation/
;; http://blog.singhanuvrat.com/problems/project-euler-the-millionth-lexicographic-permutation-of-the-digits

;; p such that (* k p) <= n < (* k (inc p))
(defn between [k n]
  (first (for [p (range n)
               :when (and (<= (* k p) n) (> (* k (inc p)) n))]
           p)))

(defn kth-digit [k remain used] ; k starts from 0
  (let [fact (u/factorial (- (count numbers) (inc k)))
        multiple (between fact remain)
        digit (nth used multiple)]
    [digit (- remain (* fact multiple)) (remove #(= digit %) used)]))

(defn but-last-3-digits [n numbers]
  (loop [i 0, remain n, digits [], used numbers]
    (if (= i (- (count numbers) 3))
      [digits remain used]
      (let [[digit new-remain new-used] (kth-digit i remain used)]
        (recur (inc i)
               new-remain
               (conj digits digit)
               new-used)))))

(defn main [n numbers]
  (let [[digits remain used] (but-last-3-digits n numbers)]
    (str/join (map str (concat digits (nth (combo/permutations used) (dec remain)))))))
