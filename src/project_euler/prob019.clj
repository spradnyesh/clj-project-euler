(ns project-euler.prob019
  (:require [clojure.string :as str]
            [project-euler.utils :as u]))

(comment (def months ["jan" "feb" "mar" "apr" "may" "jun" "jul" "aug" "sep" "oct" "nov" "dec"])
         (def year-table {0 0, 1 1, 2 2, 3 3, 4 5, 5 6, 6 0, 7 1, 8 3, 9 4,
                          10 5, 11 6, 12 1, 13 2, 14 3, 15 4, 16 6, 17 0, 18 1,
                          19 2, 20 4, 21 5, 22 6, 23 0, 24 2, 25 3, 26 4, 27 5,
                          28 0, 29 1, 30 2, 31 3, 32 5, 33 6, 34 0, 35 1, 36 3,
                          37 4, 38 5, 39 6, 40 1, 41 2, 42 3, 43 4, 44 6, 45 0,
                          46 1, 47 2, 48 4, 49 5, 50 6, 51 0, 52 2, 53 3, 54 4,
                          55 5, 56 0, 57 1, 58 2, 59 3, 60 5, 61 6, 62 0, 63 1,
                          64 3, 65 4, 66 5, 67 6, 68 1, 69 2, 70 3, 71 4, 72 6,
                          73 0, 74 1, 75 2, 76 4, 77 5, 78 6, 79 0, 80 2, 81 3,
                          82 4, 83 5, 84 0, 85 1, 86 2, 87 3, 88 5, 89 6, 90 0,
                          91 1, 92 3, 93 4, 94 5, 95 6, 96 1, 97 2, 98 3, 99 4}))

(def month-days {"jan" 31, "feb" 28, "mar" 31, "apr" 30,
                 "may" 31, "jun" 30, "jul" 31, "aug" 31,
                 "sep" 30, "oct" 31, "nov" 30, "dec" 31})
(def days ["sun" "mon" "tue" "wed" "thu" "fri" "sat"])
(def months-table {"jan" 0, "feb" 3, "mar" 3, "apr" 6,
                 "may" 1, "jun" 4, "jul" 6, "aug" 2,
                 "sep" 5, "oct" 0, "nov" 3, "dec" 5,
                 "jan-leap" 6, "feb-leap" 2})
(def century-table {17 4, 18 2, 19 0, 20 6, 21 4, 22 2, 23 0, 24 6})

(defn leap-year? [year]
  (or (zero? (rem year 400))
      (and (zero? (rem year 4))
           (not (zero? (rem year 100))))))

(defn date->ddmonccyy [date]
  (let [[dd mon yyyy] (str/split date #" ")
        cy (u/parse-int yyyy)]
    [(u/parse-int dd) mon (u/int-div cy 100) (rem cy 100)]))

;; http://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
(defn day-on-date [[dd mon cc yy]]
  (nth days (rem (+ dd
                    (months-table (if (and (leap-year? (+ (* cc 100) yy))
                                           (or (= mon "jan") (= mon "feb")))
                                    (str mon "-leap")
                                    mon))
                    yy
                    (u/int-div yy 4)
                    (century-table cc))
                 7)))

(defn month-first-dates-between [from-year-begining to-year-end]
  (for [mm (keys month-days),
        yyyy (range from-year-begining (inc to-year-end))]
    (str "1 " mm " " yyyy)))

(defn main []
  (count (filter #(= "sun" %)
                 (map (comp day-on-date date->ddmonccyy)
                      (month-first-dates-between 1901 2000)))))
