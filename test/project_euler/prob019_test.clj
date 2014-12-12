(ns project-euler.prob019-test
  (:use expectations
        project-euler.prob019))

(expect false (leap-year? 1500))
(expect true (leap-year? 1600))
(expect false (leap-year? 1603))
(expect true (leap-year? 1604))
(expect [1 "jan" 20 0] (date->ddmonccyy "1 jan 2000"))
(expect "sat" (day-on-date (date->ddmonccyy "1 jan 2000")))
(expect '("1 jun 1901" "1 sep 1901" "1 feb 1901" "1 jan 1901" "1 apr 1901" "1 nov 1901" "1 mar 1901" "1 dec 1901" "1 oct 1901" "1 may 1901" "1 aug 1901" "1 jul 1901") (month-first-dates-between 1901 1901))
(expect 171 (main))
