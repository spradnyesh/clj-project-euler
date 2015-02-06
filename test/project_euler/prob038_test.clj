(ns project-euler.prob038-test
  (:use expectations
        project-euler.prob038))

(expect false (pandigital? [1 2 3 4 4]))
(expect true (pandigital? [1 2 3 4 5 6 7 8 9]))
(expect '(9 18 27 36 45) (cat-product 9 5))
(expect '(9 1 8 2 7 3 6 4 5) (cat-digits 9 18 27 36 45))
(expect true (pandigital? (apply cat-digits (cat-product 192 3))))
(expect 932718654 (main))
