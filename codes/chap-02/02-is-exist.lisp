;; check the number
(defun is-exist (input-list is-char)
  (cond 
    ((null input-list ) "no")
    (t (if (= (CAR input-list) is-char)
           "yes"
           (is-exist (CDR input-list) is-char)
       )
    )
  )
)

(is-exist '(1 2 3) 3)
(is-exist '(1 2 3) 4) 
