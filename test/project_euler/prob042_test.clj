(ns project-euler.prob042-test
  (:use expectations
        project-euler.prob042))

(expect '(1 3 6 10 15) (take 5 (triangle-numbers)))
(expect false (is-triangle-number? 2))
(expect true (is-triangle-number? 3))
(expect 78 (word-value "\"ABILITY\""))
(expect '("\"A\"" "\"ABILITY\"" "\"ABOVE\"") (triangle-words (take 10 words)))
(expect 3 (main (take 10 words)))
