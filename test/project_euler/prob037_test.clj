(ns project-euler.prob037-test
  (:use expectations
        project-euler.prob037))

(expect false (is-prime-left? 7))
(expect false (is-prime-right? 7))
(expect false (is-prime-left? 11))
(expect false (is-prime-right? 11))
(expect true (is-prime-left? 3797))
(expect true (is-prime-right? 3797))
(expect [23 37] (n-truncatable-primes 2))
(expect 60 (main 2))
