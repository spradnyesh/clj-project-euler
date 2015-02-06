(ns project-euler.prob040-test
  (:require [clojure.math.numeric-tower :as math])
  (:use expectations
        project-euler.prob040))

(expect '("0" "1" "2" "3") (long-string 3))
(expect '(1 1 5) (ith-digits 3 (long-string (math/expt 10 3))))
(expect 5 (main 3))
