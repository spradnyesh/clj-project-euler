(ns project-euler.prob042
  (:require [project-euler.utils :as u]
            [clojure.string :as str]))

(defn triangle-numbers
  ([] (triangle-numbers 1))
  ([n] (cons (/ (* n (inc n)) 2)
             (lazy-seq (triangle-numbers (inc n))))))

(defn is-triangle-number? [n]
  (= n (last (for [i (triangle-numbers)
                   :while (<= i n)]
               i))))

(def words (str/split (slurp "src/project_euler/p042_words.txt") #","))

(defn word-value [word]
  (->> word
       (map (comp #(- % 64) int))
       (remove neg?)
       (reduce +)))

(defn triangle-words [words]
  (for [w words
        :when (is-triangle-number? (word-value w))]
    w))

(defn main [words]
  (count (triangle-words words)))
