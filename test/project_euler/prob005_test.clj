(ns project-euler.prob005-test
  (:use expectations
        project-euler.prob005))

(expect 2520 (evenly-divisible 1 10))
