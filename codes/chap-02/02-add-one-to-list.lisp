;; add one to  each element
(defun add-one-to-list (input-list)
  (if (null input-list)
     NIL
     (cons 
       (+ 1 (CAR input-list))
       (add-one-to-list (CDR input-list))
     )
   )
)
(defvar x-list '(3 4 5))
;;(write (add-one-to-list '(3 4 5)) )
(write x-list)
(format t ":")
(write (add-one-to-list x-list) )
