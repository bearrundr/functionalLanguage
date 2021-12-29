;; print all list
(defun print-all (input-list)
  (if (null input-list)
      "finish"
      (progn 
         (print (CAR input-list))
         (print-all (CDR input-list))
      )
  )
)

(print-all '(1 2 3 4))
