(ns project-euler.prob036-test
  (:use expectations
        project-euler.prob036))

(expect false (palindrome? 123))
(expect true (palindrome? 121))
(expect "100" (to-binary-string 4))
(expect nil (palindromic-10-2? 584))
(expect true (palindromic-10-2? 585))
(expect '(0 1 3 5 7 9 33 99) (numbers 100))
(expect 157 (main 100))
