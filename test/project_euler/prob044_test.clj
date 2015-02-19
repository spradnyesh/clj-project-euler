(ns project-euler.prob044-test
  (:use expectations
        project-euler.prob044))

(expect 1 (pentagonal 0))
(expect 5 (pentagonal 2))
(expect false (is-pentagonal? 2))
(expect true (is-pentagonal? 5))
(expect false (condition 1 2))
; (expect true (condition-1 1 2)) ; ???
; (expect ??? (all-combos ???)) ; ???
; (expect ??? (main-1 ???)) ; ???
(expect false (is-pentagonal?-2 2))
(expect true (is-pentagonal?-2 5))
(expect [2167 1020 7042750 1560090 5482660 8602840] (main-2 3000))
