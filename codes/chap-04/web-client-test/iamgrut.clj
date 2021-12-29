; test
(defn iamgrut []
   (Thread/sleep 3000)
   (println "Hi")
   "I'm grut"
)

(iamgrut)
@(future (iamgrut))
