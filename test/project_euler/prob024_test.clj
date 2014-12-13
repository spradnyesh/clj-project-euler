(ns project-euler.prob024-test
  (:use expectations
        project-euler.prob024))

(expect 5 (between 2 10))
(expect 5 (between 2 11))
(expect [2 274240 [0 1 3 4 5 6 7 8 9]] (kth-digit 0 1000000 numbers))
(expect [[2 7 8 3 9 1 5] 4 [0 4 6]] (but-last-3-digits 1000000 numbers))
(expect "2783915460" (main 1000000 numbers))
