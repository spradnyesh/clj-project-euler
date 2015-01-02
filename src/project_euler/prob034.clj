(ns project-euler.prob034
  (:require [project-euler.utils :as u]))

(defn curious [n]
  (if (< n 3)
    false
    (= n (reduce + (map u/factorial (u/digits n))))))

(defn curious-numbers [limit]
  (filter curious (range 3 limit)))

;; assumption: upper-limit = 9! = 362880
(defn main []
  (reduce + (curious-numbers (inc (u/factorial 9)))))
