(ns project-euler.prob053-test
  (:use expectations
        project-euler.prob053))

(expect 1144066N (combinations 23 10))
(expect 4431 (main 100 10000))
