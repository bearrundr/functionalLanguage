(ns practice.core
  (:gen-class))

(defn variable []
  (println "def variable")
  (println "(def x 12)") 
  (def x 12)
  (println "x=" x)

  (println "define local variable")
  (println "let [x 1 y 2]")
  (
     let [x 1 y 2]
     (println "(+ x y) = " (+ x y))
  )
)

(defn ifcond []
  (println "")
  (println "if condition")
  (let [x 6]
     (if (> x 5)
        (println "big")
        (println  "small") ))
)

(defn casest []
  (let [x 2]
    (case x
      1 (println "one")
      2 (println "two")
      3 (println "three")
      "otherwise")
   )
)

(defn functst []
    (println "in function")
)

(defn lambdast []

  (println "lambda statement")
  (println "((fn [x y] (+ x y)) 1 2) = " ((fn [x y] (+ x y)) 1 2))
  (println "(def f (fn [x] (+ x 1)))")
  (def f (fn [x] (+ x 1)))
  (println "(f 1)=" (f 1))
  (println "(defn f[x] (fn [y] (+ x y)))")
  (defn f[x] (fn [y] (+ x y)))
  (println "((f 1) 1)=" ((f 1) 1))
  (println "(defn f [fp] (fp 1))")
  (defn f [fp] (fp 1))
  (println "(f (fn [x] (+ x 5)))=" (f (fn [x] (+ x 5))) )

)

(defn list_and_vector [] 
  (println "list:'(1 2 3)=" '(1 2 3))
  (println "vector: [1 2 3]=" [1 2 3])
  (println "(first '(1 2 3))=" (first '(1 2 3)))
  (println "(rest '(1 2 3))=" (rest '(1 2 3)))
  (println "(first [1 2 3])=" (first [1 2 3]))
  (println "(rest [1 2 3])=" (rest [1 2 3]))
)

(defn sum-of-list [input-list]
   (println "sum-of-list=" input-list)
   (if (seq input-list)
       (+ (first input-list)
          (sum-of-list (rest input-list)))
       0
   )
)

(defn max-of-list [list]
   (println "max-of-list")

)

(defn my-map [fp list]
   (println "my-amp")

)

(defn repeatst [] 
   (println "repeatst")

   (println "dotimes")
   (dotimes [x 5]
      (println x)
   )

   (println "loop and recur")
   (loop [x 1 ret 0]
     (if (> x 10)
        (println "ret=" ret)
        (recur (inc x) (+ x ret))))

)

(defn factorial1 [n]
   (if (= 1 n) 1
       (* n (factorial1 (dec n))))
)

(defn factorial2 [x]
   (loop [n x prod 1]
     (if (= n 1) prod
         (recur (dec n) (* prod n))))
) 

(require '[clojure.string :as str])
(defn map_and_mapcat []
   (println "map and mapcat compare")
   (println "map")
   (map 
      (fn [line] (str/split line #" "))
      '("a b", "c d"))

   (mapcat
      (fn [line] (str/split line #" "))
      '("a b c", "d e f"))

)

(def content (slurp "/textfile"))
(def line_list (str/split content #"\n"))
(def word_list 
    (mapcat
       (fn [line] (str/split line #" "))
       line_list)
)
    
(defn word_listfn [] 
     (println word_list)
)

(defn reducefn []
  (println "reducefn")

  (println 
     (reduce 
       (fn [acc_map elem]
          (if (nil? (get acc_map elem))
             (assoc acc_map elem 1)
             (update acc_map elem inc)))
        {}
        word_list)
  )
)

(defn -main
  [& args]
  (println "chap 04 clojure")

  (variable)
  (ifcond)

  (casest)

  (functst)
 
  (lambdast)

  (list_and_vector)

  (println "(sum-of-list '(1 2 3 4 5))=" (sum-of-list '(1 2 3 4 5)))
  (println "(max-of-list '(4 3 2 5 1))=" (max-of-list '(4 3 2 5 1)))
  (println "(my-map (fn [x] (+ x 1))) '(1 2 3))=" (my-map (fn [x] (+ x 1)) '(1 2 3)) )

  (repeatst)

  (println "factorial1[4]=" (factorial1 4))
  (println "factorial2[4]=" (factorial2 4))
 
  (map_and_mapcat)
 
  (word_listfn)
 
  (reducefn)
)
