(ns pres4
  (:use compojure.core, ring.adapter.jetty, hiccup.core)
  (:require [compojure.route :as route]))

(defn find-primes [num divisor primes]
  (if (> num 1)
    (if (= (mod num divisor) 0)
      (recur (/ num divisor) divisor (concat primes (list divisor)))
      (if (> num 0)
        (recur num (+ 1 divisor) primes)
      (list num )))
  primes))

(defn primes [num]
  (find-primes num 2 (list)))


(defn make-list [val]
  (html [:li val]))

(defn print-list [alist]
  (html
    [:h2
    (map make-list alist)]))


(defn print-primes [num]
    (html
      (print-list (primes (Integer/parseInt num)))))

(defroutes my-routes
  (GET "/primes/:num" [num] (print-primes num)))

(run-jetty my-routes {:join? false
                      :port 8888})



