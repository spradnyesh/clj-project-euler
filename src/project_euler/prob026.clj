(ns project-euler.prob026
  (:require [project-euler.utils :as u]
            [clojure.string :as str]
            [clojure.math.numeric-tower :as math]))

(defn recurs? [n]
  (try (/ 1M n)
       false
       (catch ArithmeticException ae
         true)))

(defn str-fraction [n precision]
  (->> n
       (/ 1M)
       (with-precision (inc precision))
       str
       (drop-last 1)
       (drop 2)
       (map str)
       str/join))

(defn recurring-part [n precision]
  (let [fraction (str-fraction n precision)]
    (for [len (range 1 (/ precision 2))]
      (for [start (range 0 (inc len))
            :let [a (map #(apply str %1) (partition len (subs fraction start)))
                  f (first a)]
            :when (every? #(= % f) a)]
        f))))
