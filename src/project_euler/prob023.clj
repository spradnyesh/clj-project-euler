(ns project-euler.prob023
  (:require [project-euler.utils :as u]
            [clojure.core.memoize :as memo]
            [clojure.math.numeric-tower :as math]
            [clojure.math.combinatorics :as combo]))

(defn abundant? [n]
  (> (reduce + (u/proper-divisors n)) n))
(def m-abundant? (memo/ttl abundant? :ttl/threshold 1000000))

;; do a and b exist, such that both are abundant? and also, n = a + b

;; (time (main 1000)) => "Elapsed time: 20237.637779 msecs"
(defn sum-abundant?-1 [n]
  (if (< n 24)
    false
    (loop [acc (map (fn [[a b]] (+ a b))
                    (remove (fn [[a b]] (> a b))
                            (combo/selections (filter m-abundant? (range 1 n)) 2)))]
      (cond (= n (first acc)) true
            (empty? acc) false
            :else (recur (rest acc))))))

;; (time (main 1000)) => "Elapsed time: 932.364261 msecs"
;; "Elapsed time: 479.658512 msecs" (w/ memoization)
;; but still too slow for "(main 28123)" :( => "Elapsed time: 208293.943025 msecs"
(defn sum-abundant?-2 [n]
  (if (< n 24)
    false
    (loop [acc (filter m-abundant? (range 1 (inc (u/int-div n 2))))]
      (cond (let [f (first acc)] (and f (or (= n (* 2 f)) (m-abundant? (- n f)))))
            true

            (empty? acc)
            false

            :else (recur (rest acc))))))

(defn non-abundant-numbers [n]
  (filter (comp not sum-abundant?-2) (range 1 n)))

(defn main [n]
  (reduce + (non-abundant-numbers n)))
