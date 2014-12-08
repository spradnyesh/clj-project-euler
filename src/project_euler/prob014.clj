(ns project-euler.prob014)

(defn next-num [n]
  (if (even? n)
    (/ n 2)
    (inc (* 3 n))))

(defn chain [n]
  (loop [n n, acc [n]]
    (if (= n 1)
      acc
      (let [nn (next-num n)]
        (recur nn (conj acc nn))))))

(defn main [n]
  (first (reduce #(if (> (count %1) (count %2)) %1 %2)
                 []
                 (map chain (range 1 n)))))
