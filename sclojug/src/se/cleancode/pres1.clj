(ns pres1
  (:use compojure.core, ring.adapter.jetty))

(defroutes my-routes
  (GET "/" [] "hello"))

(run-jetty my-routes {:port 8888})