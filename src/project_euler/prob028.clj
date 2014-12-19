(ns project-euler.prob028
  (:require [clojure.math.numeric-tower :as math]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; my approach: draw the spiral and then sum diagonals
(defn rung-locs [size k [start-x start-y]]
  (let [acc (atom [])
        l (* k 2)]
    (dotimes [i l] ; down
      (swap! acc conj [start-x (+ start-y i)]))
    (dotimes [i l] ; left
      (swap! acc conj [(- start-x (inc i)) (+ start-y (dec l))]))
    (dotimes [i l] ; up
      (swap! acc conj [(- start-x l) (- (+ start-y (dec l)) (inc i))]))
    (dotimes [i l] ; right
      (swap! acc conj [(+ (- start-x l) (inc i)) (dec start-y)]))
    @acc))

(defn populate-rung [matrix k [prev-x prev-y] init-value]
  (if (zero? k)
    (let [center (int (math/floor (/ (count matrix) 2)))]
      [(assoc-in matrix [center center] init-value)
       (inc k)
       [center center]
       (inc init-value)])
    (let [rung-locs (rung-locs (count matrix) k [(inc prev-x) prev-y])
          new-init-value (+ init-value (count rung-locs))]
      [(reduce (fn [m [loc value]]
                 (assoc-in m (reverse loc) value)) ; reverse => row-major
               matrix
               (partition 2 (interleave rung-locs
                                        (range init-value new-init-value))))
       (inc k)
       (last rung-locs)
       new-init-value])))

(defn spiral [n]
  (let [matrix (vec (repeat n (vec (repeat n 0))))] ; repeat returns a lazySeq
    (first (reduce (fn [a _]
                     (apply populate-rung a))
                   (populate-rung matrix 0 [0 0] 1)
                   (range (math/floor (/ n 2)))))))

(defn diagonal-locs [size]
  (concat (for [i (range size)] [i i])
          (remove (fn [[x y]] (= x y)) ; remove center of matrix to avoid counting it twice
                  (for [i (range size)] [i (dec (- size i))]))))

(defn get-cell [matrix [x y]]
  (nth (nth matrix x) y))

(defn diagonal-sum [matrix]
  (reduce + (map #(get-cell matrix %)
                 (diagonal-locs (count matrix)))))

(defn main-1 [n]
  (diagonal-sum (spiral n)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; correct approach: use formula
;; https://projecteuler.net/quote_post=12-1aa67

(defn formula [n]
  (+ (* 4 n n) (- (* n 6)) 6))

(defn main-2 [n]
  (loop [i 3, sum 1]
    (if (> i n)
      sum
      (recur (+ i 2) (+ sum (formula i))))))
