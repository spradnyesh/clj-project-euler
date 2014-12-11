(ns project-euler.prob025
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn main [n]
  (first (for [x (iterate inc 1)
               :let [y (u/m-fib x)]
               :when (> y (math/expt 10 (dec n)))]
           x)))
