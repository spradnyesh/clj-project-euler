(ns project-euler.prob010
  (:use [clojure.math.numeric-tower :as math]))

(defn is-prime-for? [n]
  (empty? (for [i (range 2 (math/sqrt (inc n)))
                :when (= 0 (rem n i))]
            i)))

;; ???this takes drastically more time than the "for" version above???
(defn is-prime-loop? [n]
  (loop [i 2]
    (cond (> i (math/sqrt (inc n))) true
          (zero? (rem n i)) false
          :else (recur (inc i)))))

(defn primes-below-0 [n]
  (for [i (range 2 n)
        :when (is-prime-for? i)]
    i))

;; almost same time as -0
(defn primes-below-1 [n]
  (vec (map second (filter (fn [[a b]] (true? a)) (map-indexed (fn [a b] [(is-prime-for? a) b]) (range n))))))

(defn prime-sum [n]
  (reduce + (primes-below-0 n)))
