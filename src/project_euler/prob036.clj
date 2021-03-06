(ns project-euler.prob036
  (:require [clojure.string :as str]
            [project-euler.utils :as u]))

(defn palindrome? [n]
  (let [digits (u/digits n)]
    (= digits (reverse digits))))

(defn palindromic-10-2? [n]
  (when (palindrome? n)
    (let [binary-str (Integer/toBinaryString n)]
      (= binary-str (str/reverse binary-str)))))

(defn numbers [limit]
  (filter palindromic-10-2? (range limit)))

(defn main [n]
  (reduce + (numbers n)))
