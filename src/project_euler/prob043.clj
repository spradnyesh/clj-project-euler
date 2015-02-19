(ns project-euler.prob043
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

;; pre-computed for efficiency (instead of calling (u/next-prime i))
(def primes [1 2 3 5 7 11 13 17])

;; from prob041 (modified here)
(defn pandigital? [n digits]
  (and (= (count digits) n) ; for efficiency
       (= (sort digits) (range n))))

(defn unusual? [n num]
  (let [digits (u/digits num)]
    (and (zero? (rem (nth digits 3) 2)) ; d4 is divisible by 2
         ; (zero? (rem (reduce + (u/splice digits 2 3)) 3)) ; d3-6 is divisible by 3
         (if (> n 5) ; d6 is 0 or 5
           (or (zero? (nth digits 5)) (= 5 (nth digits 5)))
           true)
         (pandigital? n digits)
         (every? true? (map #(zero? (mod (u/digits->num (u/splice digits % 3))
                                         (nth primes %)))
                            (range 2 (- n 2))))
         ;; gave negligible performance gain over above map,
         ;; so commented out because above code has better readability
         (or true (comment (loop [i 1]
                             (cond (= i (- n 2)) true

                                   (not= 0 (mod (u/digits->num (u/splice digits i 3))
                                                (u/nth-prime i)))
                                   false

                                   :else (recur (inc i)))))))))

(defn all-unusual [n]
  (for [i (range (math/expt 10 (dec n)) (math/expt 10 n))
        :when (unusual? n i)]
    i))

(defn main [n]
  (reduce + (all-unusual n)))
