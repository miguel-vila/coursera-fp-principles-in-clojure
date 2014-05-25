(defproject coursera-fp-principles-in-clojure "0.1.0-SNAPSHOT"
  :description "coursera's functional principles assignments solved in clojure using typed-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure    "1.5.1"]
                 [midje "1.5.1"]
                 [org.clojure/core.typed "0.2.44"]]
  :plugins [[lein-midje "3.1.1"]
            [lein-typed "0.3.4"]]
  :core.typed {:check [coursera-fp-principles-in-clojure.hw1
                       coursera-fp-principles-in-clojure.hw2]})
