(ns project-euler.prob032-test
  (:use expectations
        project-euler.prob032))

(expect false (pandigital? [1 2 3 4 4]))
(expect true (pandigital? [1 2 3 4 5 6 7 8 9]))
(expect false (unusual? 1 2))
(expect true (unusual? 39 186))
(expect '([5346 27 198] [4396 28 157] [7254 39 186] [5796 42 138] [7632 48 159]) (products 200))
(expect 30424 (main-1 200))
(expect false (has-pandigital-products? 43))
(expect true (has-pandigital-products? 4396))
(expect 4396 (main-2 5000))
