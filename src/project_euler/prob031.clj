(ns project-euler.prob031)

(def coins [1 2 5 10 20 50 100 200])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; brute-force: works (w/in time limit) till 50
(defn is-sum? [permutation total]
  (= total (reduce + (map * coins permutation))))

(defn perms [total]
  (let [max-coins (map #(inc (/ total %)) coins)]
    (for [a1 (range (nth max-coins 0))
          a2 (range (nth max-coins 1))
          a5 (range (nth max-coins 2))
          a10 (range (nth max-coins 3))
          a20 (range (nth max-coins 4))
          a50 (range (nth max-coins 5))
          a100 (range (nth max-coins 6))
          a200 (range (nth max-coins 7))
          :let [perm [a1 a2 a5 a10 a20 a50 a100 a200]]
          :when (is-sum? perm total)]
      perm)))

(defn main-1 [total]
  (count (perms total)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; dynamic programming
;; http://csixteen.tumblr.com/post/46191646681/coin-sums-problem-31
(defn find-ways [arr m n]
  (cond (zero? n) 1
        (< n 0) 0
        (and (<= m 0) (>= n 1)) 0
        :else (+ (find-ways arr (dec m) n)
                 (find-ways arr m (- n (nth arr (dec m)))))))

(defn main-2 [total]
  (find-ways coins (count coins) total))
