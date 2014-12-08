(ns project-euler.prob010
  (:use [clojure.math.numeric-tower :as math]))

(defn is-prime-for? [n]
  (empty? (for [i (range 2 (math/sqrt (inc n)))
                :when (= 0 (rem n i))]
            i)))

(defn is-prime-loop? [n]
  (let [s (math/sqrt (inc n))]
    (loop [i 2]
      (cond (> i s) true
            (= 0 (rem n i)) false
            :else (recur (inc i))))))

(defn primes-below-0 [n]
  (for [i (range 2 n)
        :when (is-prime-for? i)]
    i))

(defn primes-below-1 [n]
  (vec (map second (filter (fn [[a b]] (true? a)) (map-indexed (fn [a b] [(is-prime-for? a) b]) (range n))))))

(defn prime-sum [n]
  (reduce + (primes-below-0 n)))
