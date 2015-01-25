(defproject project-euler "0.1.0-SNAPSHOT"
  :description "Solve problems on project-euler website"
  :url "http://projecteuler.net/problems"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.memoize "0.5.6"]
                 [expectations "2.0.13"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [org.clojure/math.combinatorics "0.0.8"]
                 [criterium "0.4.3"]
                 [org.clojure/tools.trace "0.7.8"]
                 [com.taoensso/timbre "3.2.1"]]
  :plugins [[lein-autoexpect "1.0"]])
