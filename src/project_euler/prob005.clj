(ns project-euler.prob005
  (:use [clojure.math.numeric-tower :as math :only (sqrt)])
  (:require [project-euler.utils :as u]))

(defn evenly-divisible [min max]
  (apply u/lcm (range min max)))
