(ns project-euler.prob028-test
  (:use expectations
        project-euler.prob028))

(expect [[3 2] [3 3] [2 3] [1 3] [1 2] [1 1] [2 1] [3 1]]
        (rung-locs 5 1 [3 2]))
(expect [[[0 0 0 0 0] [0 0 0 0 0] [0 0 1 0 0] [0 0 0 0 0] [0 0 0 0 0]] 1 [2 2] 2]
        (populate-rung (vec (repeat 5 (vec (repeat 5 0)))) 0 [0 0] 1))
(expect [[[0 0 0 0 0] [0 7 8 9 0] [0 6 1 2 0] [0 5 4 3 0] [0 0 0 0 0]] 2 [3 1] 10]
        (populate-rung [[0 0 0 0 0] [0 0 0 0 0] [0 0 1 0 0] [0 0 0 0 0] [0 0 0 0 0]] 1 [2 2] 2))
(expect [[21 22 23 24 25] [20 7 8 9 10] [19 6 1 2 11] [18 5 4 3 12] [17 16 15 14 13]]
        (spiral 5))
(expect [[0 0] [1 1] [2 2] [3 3] [4 4] [0 4] [1 3] [3 1] [4 0]]
        (diagonal-locs 5))
(expect 2 (get-cell [[0 0 0 0 0] [0 7 8 9 0] [0 6 1 2 0] [0 5 4 3 0] [0 0 0 0 0]] [2 3]))
(expect 101 (diagonal-sum (spiral 5)))
(expect 101 (main 5))
