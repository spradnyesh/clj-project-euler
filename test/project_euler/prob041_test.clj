(ns project-euler.prob041-test
  (:use expectations
        project-euler.prob041))

(expect false (pandigital? '(2 1 2 2)))
(expect true (pandigital? '(2 1 4 3)))
(expect 4231 (main 4))
