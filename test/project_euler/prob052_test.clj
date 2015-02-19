(ns project-euler.prob052-test
  (:use expectations
        project-euler.prob052))

(expect false (same-digits? 2 3))
(expect true (same-digits? 2 2))
(expect 142857 (main))
