(ns project-euler.prob011-test
  (:use expectations
        project-euler.prob011))

(expect 8 (get-cell 0 0))
(expect [[0 0] [0 1] [0 2] [0 3]] (right 0 0))
(expect [[0 0] [1 0] [2 0] [3 0]] (down 0 0))
(expect [[0 0] [1 -1] [2 -2] [3 -3]] (diag-left 0 0))
(expect [[0 0] [1 1] [2 2] [3 3]] (diag-right 0 0))
(expect 70600674 (main))
