(ns project-euler.prob035
  (:require [project-euler.utils :as u]
            [clojure.string :as str]))

(defn rotations [n]
  (if (< n 10)
    [n] ; for very minor performance gain
    (let [str (map str (u/digits n))]
      (loop [k (dec (count str))
             acc [str]]
        (if (zero? k)
          (map (comp u/parse-int str/join) acc)
          (recur (dec k)
                 (let [l (last acc)]
                   (conj acc (concat (rest l) [(first l)])))))))))

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
