(ns project-euler.prob035-test
  (:use expectations
        project-euler.prob035))

(expect [197 971 719] (rotations 197))
(expect false (circular-prime? 196))
(expect true (circular-prime? 197))
(expect '(3 5 7 11 13 17 31 37 71 73 79 97) (circular-primes-below 100))
(expect 13 (main 100))
