(ns coursera-fp-principles-in-clojure.hw2-test
  (:use coursera-fp-principles-in-clojure.hw2
        midje.sweet))

(facts "singleton-test"
       ((singleton-test 3) 3) => true
       ((singleton-test 3) 1) => false
       ((singleton-test 3) 2) => false)

(defn even[x]
  (== (mod x 2) 0))

(defn odd[x]
  (== (mod x 2) 1))

(defn greater-than-five[x]
  (> x 5))

(facts "union"
       ((union even greater-than-five) 0) => true
       ((union even greater-than-five) 1) => false
       ((union even greater-than-five) 3) => false
       ((union even greater-than-five) 2) => true
       ((union even greater-than-five) 6) => true
       ((union even greater-than-five) 7) => true)

(facts "intersect"
       ((intersect even greater-than-five) 0) => false
       ((intersect even greater-than-five) 1) => false
       ((intersect even greater-than-five) 2) => false
       ((intersect even greater-than-five) 3) => false
       ((intersect even greater-than-five) 6) => true
       ((intersect even greater-than-five) 7) => false
       ((intersect even greater-than-five) 8) => true)

(facts "diff"
       ((diff greater-than-five even) 0) => false
       ((diff greater-than-five even) 1) => false
       ((diff greater-than-five even) 2) => false
       ((diff greater-than-five even) 3) => false
       ((diff greater-than-five even) 4) => false
       ((diff greater-than-five even) 6) => false
       ((diff greater-than-five even) 7) => true
       ((diff greater-than-five even) 8) => false
       ((diff greater-than-five even) 9) => true
       ((diff greater-than-five even) 10) => false)

(facts "for-all"
       (fact "even numbers plus two is still an even number"
             (for-all even (fn [x] (even (+ x 2)))) => true)
       (fact "odd numbers plus two is still an odd number"
             (for-all odd (fn [x] (odd (+ x 2)))) =>  true))

(facts "exists"
       (fact "there exists an even number x such that x*2 == 1000"
             (exists even (fn [x] (== (* x 2) 1000))) => true)
       (fact "there is no odd number x such that x*2 == 1000"
             (exists odd (fn [x] (== (* x 2) 1000))) => false)
       (fact "there is no number greater than 5 that is even and odd"
             (exists greater-than-five (intersect odd even)) => false))

(defn between-10-and-30 [x]
  (< 10 x 30))

(def mapped-set (map-set between-10-and-30 (fn [x] (+ x 10))))

(facts "map-set"
       (fact ""))
