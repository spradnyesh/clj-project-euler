(ns project-euler.prob030
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

;; http://www.mathblog.dk/project-euler-30-sum-numbers-that-can-be-written-as-the-sum-fifth-powers-digits/

(defn digit-sum-raised-to [n k]
  (reduce + (map #(math/expt % k) (u/digits n))))

(defn main [k]
  (reduce + (for [i (range 2 355000)
                  :when (= i (digit-sum-raised-to i k))]
              i)))
