(ns project-euler.prob012)

(defn divisors [n]
  (loop [i 2
         acc-low [1]
         acc-high [n]]
    (if (>= i (last acc-high))
      (concat acc-low acc-high)
      (if (= 0 (rem n i))
        (if (= i (/ n i))
          (recur (inc i) (conj acc-low i) acc-high) ; needed to remove x if n is perfect square
          (recur (inc i) (conj acc-low i) (conj acc-high (/ n i))))
        (recur (inc i) acc-low acc-high)))))

(defn triangle-number [n]
  (reduce + (range (inc n))))

(defn main [n]
  (first (for [x (iterate inc 1)
               :let [y (triangle-number x)]
               :when (>= (count (divisors y)) n)]
           y)))
