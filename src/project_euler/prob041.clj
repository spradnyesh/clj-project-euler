(ns project-euler.prob041
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

;; from prob032 (modified here)
(defn pandigital? [digits]
  (= (sort digits) (range 1 (inc (count digits)))))

;; correct answer is for n=7
(defn main [n]
  (loop [i (math/expt 10 n)]
    (cond (and (pandigital? (u/digits i)) (u/is-prime? i)) i
          (= i (math/expt 10 (dec n))) nil
          :else (recur (dec i)))))
