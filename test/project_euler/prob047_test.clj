(ns project-euler.prob047-test
  (:use expectations
        project-euler.prob047))

(expect [14 15] (m-consequtive 14 2))
(expect '([14 15]) (m-consequtive-n-factors-1 2 2))
(expect '([14 15]) (main m-consequtive-n-factors-1 2))
(expect 14 (main m-consequtive-n-factors-2 2))
