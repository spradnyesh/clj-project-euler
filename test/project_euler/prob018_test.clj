(ns project-euler.prob018-test
  (:use expectations
        project-euler.prob018))


(expect '([[0 0] [1 0] [2 0] [3 0]]
            [[0 0] [1 0] [2 0] [3 1]]
            [[0 0] [1 0] [2 1] [3 1]]
            [[0 0] [1 0] [2 1] [3 2]]
            [[0 0] [1 1] [2 1] [3 1]]
            [[0 0] [1 1] [2 1] [3 2]]
            [[0 0] [1 1] [2 2] [3 2]]
            [[0 0] [1 1] [2 2] [3 3]])
        (compute-adjacent-paths small))
(expect 23 (max-path-sum small))
(expect 1074 (max-path-sum triangle))
