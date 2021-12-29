;; duplecate each element
(defun duplicate-elem (input-list)
  (if (null input-list)
     NIL
     (append 
       (list (car input-list) (car input-list))
       (duplicate-elem (cdr input-list))
     )
   )
)
(write (duplicate-elem '(3 4 5)) )
