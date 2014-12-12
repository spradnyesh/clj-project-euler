(ns project-euler.prob021
  (:require [project-euler.utils :as u]))

(defn d [n]
  (reduce + (remove #(= n %) (u/divisors n))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; brute-force => takes too long O(n^2)
(defn amicable? [a b]
  (and (= (d a) b)
       (= (d b) a)))

(defn amicable-pairs-below [n]
  (doall (for [i (range n), j (range n)
               :when (amicable? i j)]
           [i j])))

(defn main-1 [n]
  (reduce + (map first (amicable-pairs-below n))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; http://www.mathblog.dk/project-euler-21-sum-of-amicable-pairs/ => O(n)

(defn amicable-numbers [n]
  (loop [i n, acc []]
    (if (zero? i)
      acc
      (recur (dec i)
             (let [di (d i)]
               (if (and (> di i)
                        (= i (d di)))
                 (conj acc i di)
                 acc))))))

(defn main-2 [n]
  (reduce + (amicable-numbers n)))
