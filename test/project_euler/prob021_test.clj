(ns project-euler.prob021-test
  (:use expectations
        project-euler.prob021))

(expect 284 (d 220))
(expect false (amicable? 2 3))
(expect true (amicable? 220 284))
(expect '([0 1] [1 0] [6 6] [28 28]) (amicable-pairs-below 100))
(expect 35 (main-1 100))

(expect [220 284] (amicable-numbers 1000))
(expect 504 (main-2 1000))
