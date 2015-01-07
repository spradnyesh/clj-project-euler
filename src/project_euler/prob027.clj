(ns project-euler.prob027
  (:require [project-euler.utils :as u]))

(defn quad [a b n]
  (if (zero? n) b
      (+ (* n n) (* n a) b)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn max-quad-primes-1 [limit]
  (first (second (apply max-key key
                        (group-by #(nth % 2)
                                  (for [a (range (- limit) (inc limit))
                                        b (range (- limit) (inc limit))
                                        n (range)
                                        :let [quad (quad a b n)]
                                        :while (u/is-prime? quad)]
                                    [a b n]))))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn count-primes [a b]
  (count (for [n (range)
               :while (u/is-prime? (quad a b n))]
           1)))

(defn max-quad-primes-2 [limit]
  (last (sort-by #(nth % 2)
                 (remove #(zero? (nth % 2))
                         (for [a (range (- limit) (inc limit))
                               b (range (- limit) (inc limit))]
                           [a b (count-primes a b)])))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn main [limit fn]
  (let [mqp (fn limit)]
    (* (first mqp) (second mqp))))
