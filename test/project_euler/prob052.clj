(ns project-euler.prob052
  (:require [project-euler.utils :as u]))

(defn same-digits? [m n]
  (let [md (u/digits m)
        nd (u/digits n)]
    (= (sort md) (sort nd))))

(defn main []
  (first (for [i (iterate inc 1)
               :when (and (same-digits? i (* 2 i))
                          (same-digits? i (* 3 i))
                          (same-digits? i (* 4 i))
                          (same-digits? i (* 5 i))
                          (same-digits? i (* 6 i)))]
           i)))
