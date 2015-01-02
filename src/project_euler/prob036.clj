(ns project-euler.prob036
  (:require [clojure.string :as str]
            [project-euler.utils :as u]))

(defn palindrome? [n]
  (let [digits (u/digits n)]
    (= digits (reverse digits))))

(defn to-binary-string [n]
  (Integer/toBinaryString n))

(defn palindromic-10-2? [n]
  (if (palindrome? n)
    (let [binary-str (to-binary-string n)]
      (= binary-str (str/reverse binary-str)))))

(defn numbers [limit]
  (filter palindromic-10-2? (range limit)))

(defn main [n]
  (reduce + (numbers n)))
