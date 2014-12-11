(ns project-euler.prob012
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1st approach:

;;;;;;;;;;;;;;;;;;;;;;;;;
;; 1st approach: put both divisors in different vectors, and combine in end
;; continue while smaller-divisor <= previous-bigger-divisor
(defn divisors [n]
  (if (= n 1) [1]
    (loop [i 2
           acc-low [1]
           acc-high [n]]
      (if (>= i (last acc-high))
        (concat acc-low acc-high)
        (if (= 0 (rem n i))
          (if (= i (/ n i))
            (recur (inc i) (conj acc-low i) acc-high) ; needed to remove x if n is perfect square
            (recur (inc i) (conj acc-low i) (conj acc-high (/ n i))))
          (recur (inc i) acc-low acc-high))))))

;; 2nd approach: put both divisors in different vectors, and combine in end
;; continue while smaller-divisor <= (sqrt n)
;; this approach is faster :)
(defn divisors-2 [n]
  (if (= n 1) [1]
    (let [sqrt (math/sqrt n)]
      (loop [i 2, acc [1 n]]
        (if (> i sqrt)
          acc
          (if (= 0 (rem n i))
            (if (= i (/ n i))
              (recur (inc i) (conj acc i)) ; needed to remove x if n is perfect square
              (recur (inc i) (conj acc i (/ n i))))
            (recur (inc i) acc)))))))
;;;;;;;;;;;;;;;;;;;;;;;;;

(defn triangle-number [n]
  (reduce + (range (inc n))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 2nd approach based on http://mathschallenge.net/index.php?section=faq&ref=number/number_of_divisors
;; this approach is slower :(

;;;;;;;;;;;;;;;;;;;;;;;;;
;; copy-pasted from prob007

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn main [n fn]
  (first (for [x (iterate inc 1)
               :let [y (triangle-number x)]
               :when (>= (fn y) n)]
           y)))

(defn main1 [n]
  (main n (comp count divisors-2)))

(defn main2 [n]
  (main n u/num-divisors))
