(ns project-euler.prob022-test
  (:use expectations
        project-euler.prob022))

(expect 49714 (value [937 "COLIN"]))
(expect 1758 (main (take 10 names)))
