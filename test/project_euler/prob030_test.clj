(ns project-euler.prob030-test
  (:use expectations
        project-euler.prob030))

(expect 6 (digit-sum-raised-to 121 2))
(expect 19316 (main 4))
