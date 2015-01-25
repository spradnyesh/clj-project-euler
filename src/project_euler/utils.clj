(ns project-euler.utils
  (:require [clojure.math.numeric-tower :as math]
            [clojure.string :as s]
            [clojure.core.memoize :as memo]))

(defn splice [list from length]
  (for [i (range from (+ from length))]
    (nth list i)))

(def m-fib nil)
(defn fib [n]
  (cond (= n 1) 1
        (= n 2) 1
        :else (+' (m-fib (- n 1)) (m-fib (- n 2)))))
(def m-fib (memo/ttl fib :ttl/threshold 1000000))

(defn factorial [n]
  (if (zero? n)
    1
    (*' n (factorial (dec n)))))

(defn combination [n k]
  (/ (factorial n)
     (*' (factorial k) (factorial (- n k)))))

(defn pascal-triangle [n]
  (doall (cond (zero? n) [1]
               (= n 1) [1 1]
               :else (concat [1]
                             (map (fn [[a b]] (+ a b)) (partition 2 1 (pascal-triangle (dec n))))
                             [1]))))

(defn is-prime? [n]
  (if (< n 2)
    false
    (empty? (for [i (range 2 (math/sqrt (inc n)))
                  :when (= 0 (rem n i))]
              i))))

(defn next-prime [n]
  (if (< n 2)
    [2]
    (first (filter is-prime? (iterate inc (inc n))))))

(defn nth-prime [n]
  (loop [i 1
         prime 2]
    (if (= i n)
      prime
      (recur (inc i) (next-prime prime)))))

(defn prime-factors [n acc]
  (let [sqrt (math/sqrt n)]
    (loop [i 2, acc acc]
      (cond (= 1 n) acc

            (= 0 (rem n i))
            (prime-factors (/ n i) (conj acc i))

            :else (recur (next-prime i) acc)))))

;; http://mathschallenge.net/index.php?section=faq&ref=number/number_of_divisors
(defn num-divisors [n]
  (reduce * (map (comp inc count) (vals (group-by identity (prime-factors n []))))))

;; from prob-12
(defn divisors [n]
  (if (= n 1) [1]
    (let [sqrt (math/sqrt n)] ; caching (outside loop to avoid recalculation)
      (loop [i 2, acc [1 n]]
        (if (> i sqrt)
          acc
          (if (= 0 (rem n i))
            (if (= i (/ n i))
              (recur (inc i) (conj acc i)) ; needed to remove x if n is perfect square
              (recur (inc i) (conj acc i (/ n i))))
            (recur (inc i) acc)))))))

(defn proper-divisors [n]
  (remove #(= n %) (divisors n)))

;; http://planetmath.org/formulaforsumofdivisors
(defn sum-of-divisors [n]
  (let [groups (group-by identity (prime-factors n []))]
    (reduce * (map (fn [[k v]]
                     (/ (dec (math/expt k (inc (count v))))
                        (dec k)))
                   groups))))

(defn sum-of-divisors-proper [n]
  (- (sum-of-divisors n) n))

(defn is-palindrome? [n]
  (let [str (str n)]
    (=  str (s/reverse str))))

;; copied shamelessly from http://stackoverflow.com/a/3080718 :(
(defn gcd
  ([x y]
     (cond (zero? x) y
           (< y x)   (recur y x)
           :else     (recur x (rem y x))))
  ([x y & zs]
     (reduce gcd (gcd x y) zs)))

(defn lcm
  ([x y] (/ (* x y) (gcd x y)))
  ([x y & zs]
     (reduce lcm (lcm x y) zs)))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn int-div [a b]
  (int (math/floor (/ a b))))

(defn digits [num]
  (map parse-int (rest (clojure.string/split (str num) #""))))
(comment
  ;; about 3 times slower than digits (using strings) above :(
  ;; maybe because of math/floor
  (defn digits [num]
    (loop [n num, acc []]
      (if (< n 10)
        (reverse (conj acc n))
        (recur (int-div n 10) (conj acc (rem n 10)))))))

(defn digits->num [digits]
  (reduce + (map-indexed (fn [index value]
                           (* (math/expt 10 index) value))
                         (reverse digits))))
