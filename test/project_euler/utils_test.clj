(ns project-euler.utils-test
  (:use expectations
        project-euler.utils))

(expect 144 (fib 12))
(expect [3 4 5] (splice [1 2 3 4 5 6 7] 2 3))
(expect 120 (factorial 5))
(expect 252 (combination 10 5))
(expect '(1 5 10 10 5 1) (pascal-triangle 5))
(expect false (is-prime? 4))
(expect true (is-prime? 19))
(expect 19 (next-prime 17))
(expect 2 (nth-prime 1))
(expect 541 (nth-prime 100))
(expect 9 (num-divisors 100))
(expect [1 100 2 50 4 25 5 20 10] (divisors 100))
(expect false (is-palindrome? 123))
(expect true (is-palindrome? 121))
(expect 10 (gcd 10 20))
(expect 20 (lcm 10 20))
(expect (= (* 10 20) (* (gcd 10 20) (lcm 10 20))))
