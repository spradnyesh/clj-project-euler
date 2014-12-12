(ns project-euler.prob017-test
  (:use expectations
        project-euler.prob017))

(expect "one" (num->name 1))
(expect "one hundred" (num->name 100))
(expect "twenty one" (num->name 21))
(expect "two hundred" (num->name 200))
(expect "two hundred and one" (num->name 201))
(expect "two hundred and twenty one" (num->name 221))
(expect "one thousand" (num->name 1000))
(expect 864 (main 100))
