(ns project-euler.prob033
  (:require [project-euler.utils :as u]
            [clojure.set :as set]))

(defn trivial? [_ b]
  (if (zero? (rem b 10))
    true
    false))

(defn has-common-digit? [a b]
  (if (empty? (set/intersection (into #{} (u/digits a))
                                (into #{} (u/digits b))))
    false
    true))

;; for numbers having same digits
;; so that (set digits) == intersect
(defn other-digit [digits intersect]
  (if (and (> (count digits) 1)
           (not= (count digits) (count intersect))) ; for numbers like 12 21
    (first (set/difference digits intersect))
    (first digits)))

;; after (possibly) digit cancellation
(defn new-fraction [a b]
  (let [ad (into #{} (u/digits a))
        bd (into #{} (u/digits b))
        intersect (set/intersection ad bd)]
    (if-not (empty? intersect)
      (/ (other-digit ad intersect)
         (other-digit bd intersect))
      (/ a b))))

(defn digit-cancelling-fractions [n]
  (for [a (range 11 n)
        b (range 11 n)
        :when (and (< a b)
                   (not (trivial? a b))
                   (has-common-digit? a b)
                   (= (/ a b) (new-fraction a b)))]
    [a b]))

(defn main [n]
  (reduce * (map (fn [[a b]] (/ a b))
                 (digit-cancelling-fractions n))))
