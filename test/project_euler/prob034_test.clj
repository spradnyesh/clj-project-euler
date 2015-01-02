(ns project-euler.prob034-test
  (:use expectations
        project-euler.prob034))

(expect false (curious 2))
(expect true (curious 145))
(expect false (curious 144))
(expect [145 40585] (curious-numbers 362880))
(expect 40730 (main))
