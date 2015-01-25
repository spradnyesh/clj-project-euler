(ns project-euler.prob032
  (:require [project-euler.utils :as u]))

(defn pandigital? [digits]
  (and (= (count digits) 9) ; for efficiency
       (= (sort digits) [1 2 3 4 5 6 7 8 9])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; brute-force

;; optimization reduces performance by 50% :(
;; so *not* doing it
(defn unusual? [a b]
  (let [da (u/digits a)
        db (u/digits b)
        dp (u/digits (* a b))]
    (if (and (every? #(= % -1) ; should NOT contain 0
                              (map #(.indexOf % 0) [da db dp]))
                      (every? true? ; should contain distinct digits
                              (map #(= % (distinct %)) [da db dp])))
               (pandigital? (concat da db dp))
               false)))

(defn products [limit]
  (let [acc (atom [[]])]
    (drop 1 (last (for [i (range 1 limit)
                        j (range 1 limit)
                        :let [prod (* i j)]
                        :when (and (= -1 (.indexOf (map first @acc) prod))
                                   (pandigital? (concat (u/digits i) (u/digits j) (u/digits (* i j)))))]
                    (swap! acc conj [prod i j]))))))

(defn main-1 [limit]
  (reduce + (map first (products limit))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; http://www.javaproblems.com/2013/11/project-euler-problem-32-pandigital_27.html
;; n: 1 -> limit; i: 1 -> n, j: (/ n i)
;; in brute-force, i: 1 -> limit
(defn has-pandigital-products? [n]
  (loop [i 1]
    (if (= i (inc n))
      false
      (if (and (integer? (/ n i))
               (pandigital? (concat (u/digits i) (u/digits (/ n i)) (u/digits n))))
        true
        (recur (inc i))))))

(defn main-2 [limit]
  (reduce + (filter has-pandigital-products? (range 1 limit))))
