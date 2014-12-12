(ns project-euler.prob048
  (:require [clojure.math.numeric-tower :as math]))

(defn self-power [n]
  (math/expt n n))

(defn main [n m]
  (let [s (str (reduce + (map self-power (range 1 (inc n)))))
        c (count s)]
    (subs s (- c m) c)))
