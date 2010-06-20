(ns pres3
  (:use compojure.core, ring.adapter.jetty, hiccup.core)
  (:require [compojure.route :as route]))

(defn hello []
  (html [:div#foo.bar.baz "Hej!"]))


(defn make-list [val]
  (html [:li val]))

(defn print-list [alist]
  (html
    [:h2
    (map make-list alist)]))


(defroutes my-routes
  (GET "/" [] (hello))
  (GET "/list" [] (print-list (list "micke" "petra" "algot" "simon"))))
  
(run-jetty my-routes {:join? false
                      :port 8888})