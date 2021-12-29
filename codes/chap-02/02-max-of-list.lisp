;; print max of list
(defun max-of-list (input-list)
   (cond
     ((null input-list) "NON SENSE")
     ((= 1 (list-length input-list)) (CAR input-list))
     (( < 1 (list-length input-list))
        (max 
            (CAR input-list)
            (max-of-list (CDR input-list))
        )
     )
   )
)

(max-of-list '(3 1 8 2 6))
