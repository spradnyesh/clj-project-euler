(ns project-euler.prob015
  (:require [clojure.math.numeric-tower :as math]))

(reduce + (map (comp #(- % 48) int first)
               (partition 1 (str (math/expt 2 1000)))))
