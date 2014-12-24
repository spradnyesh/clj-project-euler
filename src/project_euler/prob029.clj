(ns project-euler.prob029
  (:require [clojure.math.numeric-tower :as math]))

(defn main [a b]
  (count (into #{} (for [i (range 2 (inc a))
                         j (range 2 (inc b))]
                     (math/expt i j)))))
