(ns project-euler.prob026-test
  (:use expectations
        project-euler.prob026))

(expect '(false false true false false true true false true) (map recurs? (range 1 10)))
(expect "14285714285714285714" (str-fraction 7 20))
