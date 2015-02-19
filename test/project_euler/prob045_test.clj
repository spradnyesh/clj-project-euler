(ns project-euler.prob045-test
  (:use expectations
        project-euler.prob045))

(expect 3 (triangle 2))
(expect false (is-triangle? 2))
(expect false (is-pentagonal? 2))
(expect false (is-hexagonal? 2))
(expect true (is-triangle? 1))
(expect true (is-pentagonal? 1))
(expect true (is-hexagonal? 1))
(expect '(1) (take 1 (tph)))
(expect '(1 40755) (main 2))
