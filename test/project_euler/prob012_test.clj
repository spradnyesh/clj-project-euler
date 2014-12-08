(ns project-euler.prob012-test
  (:use expectations
        project-euler.prob012))

(expect 28 (triangle-number 7))
(expect '(1 2 4 5 10 100 50 25 20) (divisors 100))
(expect 25200 (main 50))
