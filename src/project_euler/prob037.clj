(ns project-euler.prob037
  (:require [project-euler.utils :as u]
            [clojure.math.numeric-tower :as math]))

(defmacro is-prime-directional? [num fn addend]
  `(if (> ~num 10)
     (let [nd# (count (u/digits ~num))
           rslt# (for [i# (range nd#)
                       :let [new-num# (~fn ~num (math/expt 10 (- nd# i# ~addend)))]
                       :while (u/is-prime? new-num#)]
                   1)]
       (= nd# (count rslt#)))
     false))

(defn is-prime-left? [num]
  (is-prime-directional? num mod 0))

(defn is-prime-right? [num]
  (is-prime-directional? num u/int-div 1))

(defn n-truncatable-primes [n]
  (loop [n n
         i 10
         rslt []]
    (if (= 0 n)
      rslt
      (if (and (is-prime-left? i) (is-prime-right? i))
        (recur (dec n) (inc i) (conj rslt i))
        (recur n (inc i) rslt)))))

(defn main [n]
  (reduce + (n-truncatable-primes n)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(comment (defn is-prime-left? [num]
           (if (> num 10)
             (let [nd (count (u/digits num))
                   rslt (for [i (range nd)
                              :let [new-num (mod num (math/expt 10 (- nd i)))]
                              :while (u/is-prime? new-num)]
                          new-num)]
               (= nd (count rslt)))
             false))

         (defn is-prime-right? [num]
           (if (> num 10)
             (let [nd (count (u/digits num))
                   rslt (for [i (range nd)
                              :let [new-num (u/int-div num (math/expt 10 (- nd i 1)))]
                              :while (u/is-prime? new-num)]
                          new-num)]
               (= nd (count rslt)))
             false)))
