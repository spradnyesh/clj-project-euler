(ns project-euler.prob027
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn quad [a b n]
  (if (zero? n) b
      (+ (math/expt n 2) (* n a) b)))

(defn max-quad-primes [limit]
  (apply max-key key (group-by #(nth % 2) (for [a (range (- limit) (inc limit))
                                                b (range (- limit) (inc limit))
                                                n (range)
                                                :let [quad (quad a b n)]
                                                :while (u/is-prime? quad)]
                                            [a b n]))))

(defn main [limit]
  (let [mqp (first (second (max-quad-primes limit)))]
    (* (first mqp) (second mqp))))
