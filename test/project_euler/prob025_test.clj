(ns project-euler.prob025-test
  (:use expectations
        project-euler.prob025))

(expect 144 (fib 12))
(expect 476 (main 100))
