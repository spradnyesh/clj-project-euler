(ns project-euler.prob027-test
  (:use expectations
        project-euler.prob027))

(expect 14 (quad 1 2 3))
(expect [5 [[-3 7 5]]] (max-quad-primes 10))
(expect -21 (main 10))
