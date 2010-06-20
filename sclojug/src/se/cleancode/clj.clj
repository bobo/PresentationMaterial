(comment
Sample clojure source file
)
(ns se.cleancode.clj
    (:gen-class))

(defn -main
    ([greetee]
  (println (str "Hello " greetee "!")))
  ([] (-main "world")))
