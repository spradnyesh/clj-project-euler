(ns project-euler.prob014-test
  (:use expectations
        project-euler.prob014))

(expect 40 (next-num 13))
(expect 20 (next-num 40))
(expect [13 40 20 10 5 16 8 4 2 1] (chain 13))
(expect 871 (main 1000))
