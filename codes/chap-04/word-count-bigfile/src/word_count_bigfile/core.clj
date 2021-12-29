(ns word-count-bigfile.core
  (:gen-class))
(require '[clojure.java.io :as io])
(require '[clojure.string :as str])

(defn line-seq-fn []
  (with-open [rdr (io/reader "/textfile")]
    (dorun (map println (line-seq rdr))))
)

(defn frequencies-fn []
   (println (frequencies ["a" "a" "b"]))
)

(defn merge-with-fn []
  (println (merge-with + {:a 1 :b 1} {:a 3 :c 1}))

)

(defn split_by_space [line] (str/split line #" "))
(defn merge_sum_map [map1 map2] (merge-with + map1 map2))
(defn split_and_merge [map line]
  (merge_sum_map 
    map
    (frequencies (split_by_space line)))
)
(defn wordcount [filename]
  (with-open [rdr (io/reader filename)]
    (let [biglazylist (line-seq rdr)]
       (doall 
          (reduce
             (fn [acc_map line]
                (split_and_merge acc_map line))
             {}
             biglazylist ))))
)

(defn -main
  [& args]
  (println "big file word count program")

  (println "line-seq fn test")
  (line-seq-fn)
  
  (println "frequencies fn test")
  (frequencies-fn)
 
  (println "merge-with function test")
  (merge-with-fn)

  (println "bigfile word count")
  (println (wordcount "/textfile"))
  (println (wordcount "/bigfile.txt"))
)
