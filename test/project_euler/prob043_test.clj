(ns project-euler.prob043-test
  (:use expectations
        project-euler.prob043))

(expect false (pandigital? 4 [1 2 3 3]))
(expect true (pandigital? 4 [1 2 3 0]))
(expect false (unusual? 4 1234))
(expect true (unusual? 10 1406357289))
;(expect '(102 120 201 210) (all-unusual 3))
;(expect 633 (main 3))
