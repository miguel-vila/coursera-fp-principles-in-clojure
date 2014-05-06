(ns coursera-fp-principles-in-clojure.hw1
  (:require [clojure.core.typed :as typed]))

(typed/ann pascal [Number Number -> Number])
(defn pascal [c r]
  (cond
   (or (< c 0) (< r 0)) (throw (Exception. "No negative numbers accepted"))
   (> c r) (throw (Exception. (str "The column number (" c ") can't be greater than the row number (" r ")")))
   (or (= c 0) (= c r)) 1
   :else (+ (pascal (- c 1) (- r 1)) (pascal c (- r 1)))))

(pascal 1 2)

(typed/ann balance [String -> Boolean])
(defn balance [l]
  (typed/letfn> [balance-loop :- [(typed/Seq Character) Number -> Boolean]
                 (balance-loop [l parens-to-be-closed]
                        (cond (empty? l) (= parens-to-be-closed 0)
                              (= (first l) \() (balance-loop (rest l) (+ parens-to-be-closed 1))
                              (= (first l) \))
                                (if (= parens-to-be-closed 0)
                                  false
                                  (balance-loop (rest l) (- parens-to-be-closed 1)))
                              :else (balance-loop (rest l) parens-to-be-closed)))]
    (let [seq-l (seq l)] ;seq-l is of type Option(Seq(Character))
      (if seq-l
        (balance-loop seq-l 0)
        true))))

(typed/ann count-change [Number (typed/Coll Number) -> Number])
(defn count-change [money coins]
  (cond (empty? coins) 0
        (= money 0) 1
        :else (let [f (first coins)]
                (if (>= money f)
                  (+ (count-change (- money f) coins) (count-change money (rest coins)))
                  (count-change money (rest coins))))))

(count-change 4 [1 2 3])
