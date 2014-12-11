(ns project-euler.prob025
  (:require [clojure.math.numeric-tower :as math]
            [clojure.core.memoize :as memo]))

(def m-fib nil)
(defn fib [n]
  (cond (= n 1) 1
        (= n 2) 1
        :else (+' (m-fib (- n 1)) (m-fib (- n 2)))))
(def m-fib (memo/ttl fib :ttl/threshold 1000000))

(defn main [n]
  (first (for [x (iterate inc 1)
               :let [y (m-fib x)]
               :when (> y (math/expt 10 (dec n)))]
           x)))
