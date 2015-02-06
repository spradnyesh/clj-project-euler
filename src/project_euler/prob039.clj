(ns project-euler.prob039
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn square [n]
  (* n n))

(defn right-angled? [a b c]
  (cond (and (> a b) (> a c))
        (= (square a) (+ (square b) (square c)))

        (and (> b a) (> b c))
        (= (square b) (+ (square a) (square c)))

        (and (> c b) (> c a))
        (= (square c) (+ (square b) (square a)))))

(defn perimeter-combos [p]
  (distinct (for [a (range 1 (u/int-div p 2))
                  b (range 1 (u/int-div p 2))
                  ; c (range 1 (u/int-div p 3)) ;; WRONG for performance
                  :let [c (- p (+ a b))]
                  :when (and ; (= p (+ a b c)) ;; WRONG for performance
                             (right-angled? a b c))]
              #{a b c})))

(defn range-combos [n]
  (sort-by first
           (map (fn [i]
                  [(count (perimeter-combos i)) i])
                (range (inc n)))))

(defn main [n]
  (last (range-combos n)))
