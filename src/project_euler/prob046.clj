(ns project-euler.prob046
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn is-odd-composite? [n]
  (and (> n 1)
       (odd? n)
       (not (u/is-prime? n))))

(defn is-perfect-square? [n]
  (let [root (math/expt n 0.5)]
    (= root (* 1.0 (int root)))))

(defn is-goldbach-other? [n primes]
  (loop [primes primes]
    (cond (empty? primes) false
          (is-perfect-square? (/ (- n (first primes)) 2)) true
          :else (recur (rest primes)))))

(defn main []
  (loop [primes (u/primes-between 1 8)
         i 9]
    (let [new-primes (concat primes (u/primes-between (last primes) i))]
      (if (and (is-odd-composite? i)
               (not (is-goldbach-other? i new-primes)))
        i
        (recur new-primes (inc i))))))
