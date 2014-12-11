(ns project-euler.prob004-test
  (:use expectations
        project-euler.prob004))

(expect 9009 (largest-palindrome 2))
(expect 906609 (largest-palindrome 3))
