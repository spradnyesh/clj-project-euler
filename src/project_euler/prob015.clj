(ns project-euler.prob015
  (:require [project-euler.utils :as u]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-1 : StackOverflowError :(

(defn next-locs [size [x y]]
  (cond (and (< x size) (< y size))
        [[(inc x) y] [x (inc y)]]
        (< x size)
        [[(inc x) y]]
        (< y size)
        [[x (inc y)]]
        :else nil))

(defn traverse [size x y]
  (loop [in [[[x y]]], out []]
    (if (empty? in)
      out
      (let [f (first in)
            l (last f)
            [x y] l
            nl (next-locs size l)]
        (if nl
          (recur (concat (rest in) (map #(conj f %) nl)) out)
          (if (and (= x size) (= y size))
            (recur (rest in) (conj out f)) ; reached sizeXsize end-point
            (recur (rest in) out)))))))    ; reached outside lattice

(defn main-1 [n]
  (count (traverse n 0 0)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-2: my approach -> WRONG :(
;; lp(1) = 2
;; lp(n) = (n^2 - (n-1)^2) * lp(n-1)

(defn square [n]
  (*' n n))

(defn lp [n]
  (if (= n 1)
    2
    (*' (lp (dec n))
        (-' (square n) (square (dec n))))))

(defn main-2 [n]
  (lp n))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-3 : http://www.mathblog.dk/project-euler-15/, http://copingwithcomputers.com/2013/07/06/lattice-paths/

(defn main-3 [n]
  (let [pt (u/pascal-triangle (* 2 n))]
    (nth pt (/ (count pt) 2))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; approach-4 : http://www.mathblog.dk/project-euler-15/, http://copingwithcomputers.com/2013/07/06/lattice-paths/

(defn main-4 [n]
  (u/combination (* 2 n) n))
