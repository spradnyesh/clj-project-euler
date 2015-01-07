(ns project-euler.prob027-test
  (:use expectations
        project-euler.prob027))

(expect 14 (quad 1 2 3))
(expect [-3 7 5] (max-quad-primes-1 10))
(expect 40 (count-primes 1 41))
(expect [-3 7 6] (max-quad-primes-2 10))
(expect -21 (main 10 max-quad-primes-1))
(expect -21 (main 10 max-quad-primes-2))
