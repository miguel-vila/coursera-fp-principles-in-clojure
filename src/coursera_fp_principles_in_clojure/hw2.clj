(ns coursera-fp-principles-in-clojure.hw2
  (:require [clojure.core.typed :refer [ann fn> letfn>]]))

(ann singleton-test [Number -> [Number -> Boolean]])
(defn singleton-test [elem]
  (fn [x] (== x elem)))

(ann union [[Number -> Boolean] [Number -> Boolean] -> [Number -> Boolean]])
(defn union [s t]
    (fn [x] (or (s x) (t x))))

(ann intersect [[Number -> Boolean] [Number -> Boolean] -> [Number -> Boolean]])
(defn intersect [s t]
    (fn [x] (and (s x) (t x))))

(ann diff [[Number -> Boolean] [Number -> Boolean] -> [Number -> Boolean]])
(defn diff [s t]
  (fn [x] (and (s x) (not (t x)))))

(ann filter [[Number -> Boolean] [Number -> Boolean] -> [Number -> Boolean]])
(def filter intersect)

(ann for-all [[Number -> Boolean] [Number -> Boolean] -> Boolean])
(defn for-all [s p]
  (letfn> [iter :- [Number -> Boolean]
                 (iter [a]
                (cond (> a 1000) true
                      (and (s a) (not (p a))) false
                      :else (iter (+ a 1))))]
  (iter -1000)))

(ann exists [[Number -> Boolean] [Number -> Boolean] -> Boolean])
(defn exists [s p]
  ((comp not for-all) s (complement p)))

(ann map-set [[Number -> Boolean] [Number -> Number] -> [Number -> Boolean]])
(defn map-set [s f]
  (fn [x] (exists s (fn> [y :- Number] (== (f y) x)))))
