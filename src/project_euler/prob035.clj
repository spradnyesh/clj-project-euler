(ns project-euler.prob035
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn rotations [n]
  (cond (< n 10) [n]
        (< n 100) [n (let [[a b] (reverse (u/digits n))] (+ b (* 10 a)))]
        :else (let [size (dec (count (str n)))
                    divisor (math/expt 10 size)]
                (loop [k size
                       acc [n]]
                  (if (zero? k)
                    acc
                    (recur (dec k)
                           (let [l (last acc)]
                             (conj acc (+ (* (rem l divisor) 10)
                                          (u/int-div l divisor))))))))))

(defn circular-prime? [n]
  (let [rotations (rotations n)]
    ;; https://projecteuler.net/quote_post=69-46c64
    ;; decreases time by factor of 2
    ;; this works because in the rotation the last digit will be even and hence not prime
    (if-not (every? odd? rotations)
      false
      (= (count rotations)
         (count (for [k rotations
                      :while (u/is-prime? k)]
                  k))))))

(defn circular-primes-below [n]
  (filter circular-prime? (range 2 n)))

(defn main [n]
  (inc (count (circular-primes-below n)))) ; "2" gets missed in circular-prime?
