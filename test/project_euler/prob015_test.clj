(ns project-euler.prob015-test
  (:use expectations
        project-euler.prob015))

;; approach-1
(expect [[1 0] [0 1]] (next-locs 2 [0 0]))
(expect [[1 1] [0 2]] (next-locs 2 [0 1]))
(expect [[2 0] [1 1]] (next-locs 2 [1 0]))
(expect nil (next-locs 2 [2 2]))
(expect [[[0 0] [1 0] [2 0] [2 1] [2 2]] [[0 0] [1 0] [1 1] [2 1] [2 2]] [[0 0] [1 0] [1 1] [1 2] [2 2]] [[0 0] [0 1] [1 1] [2 1] [2 2]] [[0 0] [0 1] [1 1] [1 2] [2 2]] [[0 0] [0 1] [0 2] [1 2] [2 2]]] (traverse 2 0 0))

;; approach-2
(expect 6 (lp 2))

;; approach-3
(expect '(1 5 10 10 5 1) (pascal-triangle 5))
(expect 20 (main-3 3))

;; approach-4
(expect 120 (factorial 5))
(expect 252 (combination 10 5))
(expect 20 (main-4 3))
