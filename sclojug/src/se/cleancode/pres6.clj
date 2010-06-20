(ns pres6
 (:use compojure.core, ring.adapter.jetty, hiccup.core, hiccup.form-helpers, ring.middleware.session)
 (:require [compojure.route :as route]))

(defn login []
  (html
    (form-to [:post "/do"]
      "Please Login"
      [:br]
      (text-field :username)
      [:br]
      (password-field :pass)
      [:br]
      (submit-button "Login")
      (reset-button "reset"))))


(defn do-login [session params]
  {:body (str "set session" (params "username" ))
   :session {:username (params "username") :pass (params "pass")}})

   (defn validate [session]
       (if (empty? (:username session))
        (html [:h1 "please login"])
       (html [:h1 (str "welcomme: " (:username session))])))


   (defroutes my-routes
     (GET "/" [] (login))
     (ANY  "/do" {params :params} (do-login :session params))
     (ANY "/verify" {session :session} (validate session)))


   (wrap! my-routes :session)

   (run-jetty my-routes {:join? false
                         :port 8888})