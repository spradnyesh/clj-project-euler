(ns project-euler.prob022
  (:require [clojure.string :as str]))

(def names (sort (map #(str/replace % "\"" "")
                      (str/split (slurp "src/project_euler/p022_names.txt") #","))))

(defn value [[idx itm]]
  (* (inc idx)
     (reduce + (map (comp #(- % 64) int) (seq (char-array itm))))))

(defn main [names]
  (let [in (map-indexed vector names)]
    (reduce + (map value in))))
