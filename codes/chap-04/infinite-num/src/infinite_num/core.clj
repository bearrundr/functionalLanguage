(ns infinite-num.core
  (:gen-class))

(defn infinite-num [n]
  (cons n
      (lazy-seq (infinite-num (+ n 1)))
  )
)

(def list (take 10 (infinite-num 0)))

(defn -main
  [& args]
  (println (take 10 (infinite-num 0)) )

  (println (type list))
  
)
