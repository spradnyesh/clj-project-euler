(ns project-euler.prob033-test
  (:use expectations
        project-euler.prob033))

(expect false (trivial? 10 11))
(expect true (trivial? 10 10))
(expect false (has-common-digit? 11 22))
(expect true (has-common-digit? 11 21))
(expect 1 (other-digit #{1 2} #{2}))
(expect 2 (other-digit #{2} #{2}))
(expect 1 (other-digit #{1 2} #{ 12}))
(expect 1/2 (new-fraction 49 98))
(expect 1/2 (new-fraction 1 2))
(expect '([16 64] [19 95] [26 65] [49 98]) (digit-cancelling-fractions 100))
(expect 1/100 (main 100))
