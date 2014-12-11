(ns project-euler.prob008
  (:require [project-euler.utils :as u]))

(defn str-prod [s]
  (reduce * (map #(Integer/parseInt (str %)) s)))

(defn largest-product [n length]
  (let [str (str n)
        largest (atom 0)]
    (dotimes [i (- (count str) (dec length))]
      (let [sp (u/splice str i length),
            prod (str-prod sp)]
        (when (> prod @largest)
          (swap! largest #(do %2) prod))))
    @largest))
