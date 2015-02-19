(ns project-euler.prob045
  (:require [project-euler.utils :as u]))

(defn triangle [n]
  (/ (* n (inc n)) 2))

(defn is-triangle? [n]
  (let [root (first (filter pos? (u/quadratic-roots 1 1 (* 2 (- n)))))]
    (= root (* 1.0 (int root)))))

(defn is-pentagonal? [n]
  (let [root (first (filter pos? (u/quadratic-roots 3 -1 (* 2 (- n)))))]
    (= root (* 1.0 (int root)))))

(defn is-hexagonal? [n]
  (let [root (first (filter pos? (u/quadratic-roots 2 -1 (- n))))]
    (= root (* 1.0 (int root)))))

(defn tph []
  (for [i (iterate inc 1)
        :let [t (triangle i)]
        :when (and (is-pentagonal? t)
                   (is-hexagonal? t))]
    t))

(defn main [n]
  (doall (take n (tph))))
