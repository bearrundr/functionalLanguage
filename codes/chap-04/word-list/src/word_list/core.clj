(ns word-list.core
  (:gen-class))

(def word-list '("Jack" "Bauer" "Tony" "almeida" ))

(defn random-from-list [list]
   (nth list
      (rand-int (count list)))
)

(defn infinite-word [word-list]
  (cons 
     (random-from-list word-list)
     (lazy-seq (infinite-word word-list))
  )
)

(defn bigfile-write []
   (with-open [w (clojure.java.io/writer "/bigfile.txt")]
      (doseq [word (take 20000000 (infinite-word word-list))]
         (.write w (str word "\n"))))
)

(defn doitslow [x]
  (Thread/sleep 1000)
  (println x)
  (+ 1 x)
)

; dorun, doall
(defn slowly [x] (Thread/sleep 1000) (+ x 1))

(defn -main
  [& args]
 
  (println (random-from-list word-list))
  (println (random-from-list word-list))

  (println (take 3 (infinite-word word-list)) )

  (println "bigfile write")
; take long time for writing bigfile so it is commented
;  (bigfile-write)
  (doseq [elem '(1 2 3)]
     (println elem)
  )

  ; lazy
  (println "lazy  for act")

  (def lazylist
    (for [elem '(1 2 3)]
      (doitslow elem))    ; not run
  )
  (println (realized? lazylist)) ; not run
  (println lazylist) ; run
  (println (realized? lazylist)) ; run check is true
  
  (println "not lazy  for act")
; not lazy act
  (def notlazylist
    (doseq [elem '(1 2 3)]
      (doitslow elem)) ;; directly run
  )

  (println "dorun doall compare")
  (def foo (map slowly [1 2 3]))
  (println (realized? foo))
  (println foo)
  (println (realized? foo))

  (println "doall")
  (def foo1 (doall (map slowly [1 2 3])))
  (println (realized? foo1))
  (println foo1)
  (println "(type foo1)=" (type foo1))

  (def foo2 (dorun (map println [1 2 3])))
  (println "(type foo2)=" (type foo2))
)
