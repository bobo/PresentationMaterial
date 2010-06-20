(ns pres2
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]))

(defn hello []
  "<h1>mjao</h1>")

(defroutes my-routes
  (GET "/" [] (hello)))

(run-jetty my-routes {:join? false
                      :port 8888})