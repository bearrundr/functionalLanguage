;; sum of list
(defun sum-of-list (input-list)
   (if (null input-list)
          0
          (+ 
             (CAR input-list)
             (sum-of-list (CDR input-list))
          )
   )
)

(sum-of-list '(1 2 3))
