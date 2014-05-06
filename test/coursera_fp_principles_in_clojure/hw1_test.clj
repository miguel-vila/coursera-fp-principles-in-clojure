(ns coursera-fp-principles-in-clojure.hw1-test
  (:use coursera-fp-principles-in-clojure.hw1
        midje.sweet))

(facts "pascal"
       (pascal 0 2) => 1
       (pascal 1 2) => 2
       (pascal 1 3) => 3)

(facts "balance"
       (balance "(if (zero? x) max (/ 1 x))") => true
       (balance "I told him (that it's not (yet) done).\n(But he wasn't listening)") => true
       (balance ":-)") => false
       (balance "())(") => false)

(facts "count-change"
       (count-change 4 [1 2]) => 3
       (count-change 300 [5 10 20 50 100 200 500]) => 1022
       (count-change 301 [5 10 20 50 100 200 500]) => 0
       (count-change 301 [500 5 50 100 20 200 10]) => 0)


