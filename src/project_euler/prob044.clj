(ns project-euler.prob044
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as s]
            [clojure.core.memoize :as memo]))

(defn pentagonal [n]
  (if (< n 1)
    1
    (/ (* n (- (* n 3) 1)) 2)))
;; 75% time of that of w/o memoization
(def m-pentagonal (memo/ttl pentagonal :ttl/threshold 1000000))

(defn is-pentagonal? [n]
  (loop [k 1]
    (let [p (m-pentagonal k)]
      (cond (= p n) true
            (> p n) false
            :else (recur (inc k))))))
;; less than 50% time of that of w/o memoization
(def m-is-pentagonal? (memo/ttl is-pentagonal? :ttl/threshold 1000000))

(defn condition [i j]
  (and (m-is-pentagonal? i)
       (m-is-pentagonal? j)
       (m-is-pentagonal? (+ i j))
       (m-is-pentagonal? (- i j))))

(defn all-combos [limit]
  (comment (doall (for [i (range 1 limit)
                        j (range 1 limit)
                        :when (condition i j)]
                    [i j])))
  ;; almost less than 50% time of that of above "for"
  (loop [i 1
         acc-out []]
    (cond (= i limit) acc-out
          :else (recur (inc i)
                       (concat acc-out
                               (loop [j (inc i)
                                      acc-in []]
                                 (cond (= j limit) acc-in
                                       (condition i j) (recur (inc j)
                                                              (conj acc-in [i j]))
                                       :else (recur (inc j) acc-in))))))))

(defn main [limit]
  (apply min (map #(- (second %) (first %))
                  (all-combos limit))))
