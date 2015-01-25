(ns project-euler.prob031-test
  (:use expectations
        project-euler.prob031))

(expect false (is-sum? [] 10))
(expect true (is-sum? [0 0 0 0 1] 20))
(expect '([0 0 0 1 0 0 0 0] [0 0 2 0 0 0 0 0] [0 5 0 0 0 0 0 0] [1 2 1 0 0 0 0 0] [2 4 0 0 0 0 0 0] [3 1 1 0 0 0 0 0] [4 3 0 0 0 0 0 0] [5 0 1 0 0 0 0 0] [6 2 0 0 0 0 0 0] [8 1 0 0 0 0 0 0] [10 0 0 0 0 0 0 0]) (perms 10))
(expect 11 (main-1 10))
(expect 11 (find-ways coins (count coins) 10))
(expect 11 (main-2 10))
