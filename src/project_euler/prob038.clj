(ns project-euler.prob038
  (:require [project-euler.utils :as u]
            [clojure.string :as str]))

;; prob032
(defn pandigital? [digits]
  (and (= (count digits) 9) ; for efficiency
       (= (sort digits) [1 2 3 4 5 6 7 8 9]))) ; almost equivalent to (= 9 (count (distintct digits)))

(defn cat-product [num limit]
  (map #(* num %) (range 1 (inc limit))))

(defn cat-digits [& nums]
  (mapcat u/digits nums))

(defn main []
  (->> (for [n (range 1 10000)
             i (range 1 10)
             :let [digits (apply cat-digits (cat-product n i))]
             :when (pandigital? digits)]
         digits)
       last
       (map str)
       (str/join "")
       Integer/parseInt))
