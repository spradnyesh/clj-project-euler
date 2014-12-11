(ns project-euler.prob004
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defn largest-palindrome [size]
  (apply max (for [i (range (math/expt 10 (dec size)) (math/expt 10 size))
                   j (range (math/expt 10 (dec size)) (math/expt 10 size))
                   :let [prod (* i j)]
                   :when (u/is-palindrome? prod)]
               prod)))
