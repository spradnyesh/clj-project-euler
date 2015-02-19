(ns project-euler.prob047
  (:require [project-euler.utils :as u]))

(defn m-consequtive [start m]
  (loop [i 1, acc [start]]
    (if (= i m)
      acc
      (recur (inc i)
             (conj acc (inc (last acc)))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; bf approach-1

(defn m-consequtive-n-factors-1 [m n]
  (doall (take 1 (for [i (iterate inc 1)
                       :let [m-cons (m-consequtive i m)
                             m-factors (map (comp count distinct #(u/prime-factors % [])) m-cons)]
                       :when (every? #(= n %) m-factors)]
                   m-cons))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; bf approach-2
;; don't find prime-factors of i+1 if i itself does not satisfy criteria
;; improves performance by more than 50% for k = 3
;; but still unsolvable for k = 4 :(

(defn m-consequtive-n-factors-2 [m n]
  (loop [i 1
         m-cons (m-consequtive i m)
         rslt nil]
    (if (not (nil? rslt))
      rslt
      (recur (inc i)
             (m-consequtive (inc i) m)
             (loop [m-cons m-cons]
               (cond (empty? m-cons) i

                     (not= n (-> (first m-cons)
                                 (u/prime-factors [])
                                 distinct
                                 count))
                     nil

                     :else (recur (rest m-cons))))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn main [f k]
  (f k k))
