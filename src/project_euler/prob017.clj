(ns project-euler.prob017
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(def num-to-name-map
  {1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten"
   11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen"
   16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen" 20 "twenty"
   30 "thirty" 40 "forty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety" 100 "hundred"})

(defn between-1-100 [num]
  (cond (= num 100) "one hundred"
        (< num 21) (num-to-name-map num)
        :else (let [tens (* (int (math/floor (/ num 10.0))) 10)
                    units (rem num 10)]
                (str (num-to-name-map tens) " " (num-to-name-map units)))))

(defn between-101-999 [num]
  (let [hundreds (int (math/floor (/ num 100.0)))
        others (rem num 100)
        use-and (not (zero? others))]
    (if use-and
      (str (num-to-name-map hundreds) " hundred and " (between-1-100 others))
      (str (num-to-name-map hundreds) " hundred"))))

(defn num->name [num]
  (cond (= num 1000) "one thousand"
        (< num 101) (between-1-100 num)
        :else (between-101-999 num)))

(defn main [n]
  (count (clojure.string/join (clojure.string/split (clojure.string/join (map num->name (range 1 (inc n)))) #" "))))
