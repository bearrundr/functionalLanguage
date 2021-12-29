;;;; chapter 02 source list
;; s-expression
(print "S expression")
;; 15
(+ 1
   2
   3
   4
   5
)
;; 6
(+ 1
   (+ 2 3)
)
;; 14
(+
  (+ 
     (+ 2 3)
     (+ 4 5)
  )
)
;; function
(print "function")
(defun sum
  (x y)
  "sum x and y"
  (+ x y)
)
(sum 1 2)
;; global variable
(print "defvar, defparameter")
(print "defvar is immutable")
(print "defparameter is mutable")
(defvar *x* 12)
*x*
(defvar *x* 13)
*x*
(defparameter *y* 14)
*y*
(defparameter *y* 15)
*y*
;; local variable
;; let and let*
(print "let and let*")
(print "4 expected")
(let ((x 1) (y 2)) (+ x y 1))
;; following is error
;;(let ((x 1) (y x)) (+ x y 1))
(let* ((x 1) (y x)) (+ x y 1))
;;
;; if condition
(defvar x1 123)
x1
(if (> x1 3)
    "x1 > 3"
    "x1 < 3"
)
;;
;; if condition in function
;;
(defun compare3 (x)
   (if (> x 3)
       "x > 3"
       "x < 3"
   )
)
(compare3 10)
;;
"progn"
(defvar x2 123)
(if (> x2 3)
   (progn
     (print "yes")
     (print "and this too!")
   )
   (print "no")
)

;;
;; cond (switch)
;;
(defvar x3 12)
(cond 
    ((< x3 8) "minus")
    ((> x3 18) "over")
    (t "else")
)
;; 
;; List
;;
(print "list")
'(1 2 3 4 5)
;; (loop (print (eval (read))))
;;
;; cons cell, cdr, car
;;
(car '(1 2 3))
(cdr '(1 2 3))
(car 
   (cdr 
     (cdr '(1 2 3))
   )
)
;;
;; cons and append
;;
(cons '(1 2) '(2 3))
(cons '(1) '(2 3))
(cons 9 '(2 3))
(append '(1 2) '(2 3))

;;
;; recursive function
;;
;; print 0 to 10 and finally print finish
(defun myself (x)
  (if (> x 10) "finish"
     (progn
        (print x)
        (myself(+ x 1))
     )
  )
)

(myself 0)
;;
;; fibonachi number
;;
(defun fibo (n) 
   (cond 
     ((= n 1) 1)
     ((= n 2) 1)
     (t (+
          (fibo (- n 1))
          (fibo (- n 2))
        )
     )
   )
)
(fibo 10)

;;

; lambda
(lambda (x) (+ 1 x))

; high order function
; mapcar, remove-if, reduce
(mapcar 
  (lambda (x) (+ 1 x))
  '(1 2 3)
)
; remove if
(remove-if 
  (lambda (x) (= x 2))
  '(1 2 3)
)

; reduce
(reduce
  (lambda (x y) (+ x y))
  '(1 2 3 4 5)
)
