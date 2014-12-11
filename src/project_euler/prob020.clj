(ns project-euler.prob020)

(defn factorial [n]
  (if (= 1 n)
    1
    (*' n (factorial (dec n)))))


(defn main []
  (reduce + (map (comp #(- % 48) int first)
                 (partition 1 (str (factorial 10))))))
