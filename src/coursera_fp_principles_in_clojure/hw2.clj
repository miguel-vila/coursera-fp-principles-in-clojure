(ns coursera-fp-principles-in-clojure.hw2)

(defn singleton-test [elem]
  (fn [x] (= x elem)))

(defn union [s t]
    (fn [x] (or (s x) (t x))))

(defn intersect [s t]
    (fn [x] (and (s x) (t x))))

(defn diff [s t]
  (fn [x] (and (s x) (not (t x)))))

(def filter intersect)

(defn for-all [s p]
  (letfn [(iter [a]
                (cond (> a 1000) true
                      (not (p a)) false
                      :else (iter (+ a 1))))]
  (iter -1000)))

(defn exists [s p]
  (letfn [(negated [x] (not (p x)))]
  ((comp not for-all) s negated)))

(defn map [s f]
  (fn [x] (exists s (fn [y] (= (f y) x)))))
