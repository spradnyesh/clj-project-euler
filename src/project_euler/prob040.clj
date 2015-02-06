(ns project-euler.prob040
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as str]))

(defn long-string [n]
  (rest (str/split (str/join "" (map str (range (inc n)))) #"")))

(defn ith-digits [n ls]
  (map (comp #(Integer/parseInt %)
             (fn [k]
               (nth ls (math/expt 10 k))))
       (range n)))

(defn main [n]
  (reduce * (ith-digits n (long-string (math/expt 10 n)))))
