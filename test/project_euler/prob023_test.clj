(ns project-euler.prob023-test
  (:use expectations
        project-euler.prob023))

(expect false (abundant? 11))
(expect true (abundant? 12))
(expect false (abundant? 13))
(expect false (sum-abundant?-1 23))
(expect true (sum-abundant?-1 24))
(expect false (sum-abundant?-1 25))
(expect false (sum-abundant?-2 23))
(expect true (sum-abundant?-2 24))
(expect false (sum-abundant?-2 25))
(expect '(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 25 26 27 28 29 31 33 34 35 37 39 41 43 45 46 47 49 51 53 55 57 59 61 63 65 67 69 71 73 75 77 79 81 83 85 87 89 91 93 95 97 99) (non-abundant-numbers 100))
(expect 2766 (main 100))
