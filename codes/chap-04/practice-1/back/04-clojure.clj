;; 1. variable definition
(println "variable definition")
(def x 12)
x

;; 2. local variable def
(println "local var def")
(def x 12)
x

;; scope in local variable
(println "scope within local variable")
(let [x 1 y 2]
   (+ x y))

;; conditional if stat
(println "if statement")
(let [x 6]
  (if (> x 5)
    "big"
    "small"))

;; case stat
(println "case statements")
(let [x 2]
  (case x
    1 "one"
    2 "two"
    3 "three"
    "otherwise"))

;; function definition
(println "function definition")
(defn sum [x y]
  (+ x y))
(sum 1 2)

;; lambda function
(println "lambda function")
(fn [x y] (+ x y))
((fn [x y] (+ x y)) 1 2)
(def f (fn [x] (+ 1 x)))
(f 1)

;; return lambda function
(println "return lambda function")
(defn f [x] (fn [y] (+ x y)))
((f 1) 2)

;; a argument is a function
(println "a argument is a function")
(defn f [fp] (fp 1))
(f (fn [x] (+ x 1)))

;; list and vector
(println "list and vector")
(println "car is first, cdr is rest")
(println "first '(1 2 3) = 1")
(first '(1 2 3))

(println "rest of '(1 2 3) = (2 3)")
(rest '(1 2 3))

(println "vector is the same")
(first [1 2 3])
(rest [1 2 3])
