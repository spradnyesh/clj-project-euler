(ns project-euler.prob053
  (:require [project-euler.utils :as u]))

(defn combinations [n r]
  (/ (u/m-factorial n) (*' (u/m-factorial r) (u/m-factorial (- n r)))))

(defn main [n limit]
  (loop [i 1, cnt-out 0]
    (if (> i n)
      cnt-out
      (recur (inc i)
             (loop [j 1, cnt-in cnt-out]
               (cond (= j i) cnt-in
                     (> (combinations i j) limit) (recur (inc j) (inc cnt-in))
                     :else (recur (inc j) cnt-in)))))))
