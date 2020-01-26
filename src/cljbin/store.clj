(ns cljbin.store
  (:require [com.stuartsierra.component :as component]
            [taoensso.carmine :as car :refer (wcar)]
            [clojure.tools.logging :as log]
            [nano-id.core :refer [nano-id]]))

(defn add-new-paste
  "Insert a new paste in the database, then return its UUID."
  [content]
  (let [uuid (nano-id 10)]
    (wcar * (car/set uuid content))
    uuid))

(defn get-paste-by-uuid
  "Find the paste corresponding to the passed-in uuid, then return it."
  [uuid]
  (wcar * (car/get uuid)))

(def redis-server-conf {:pool {} :spec {:uri "redis://localhost:6379"}})

(defn make-store
  []
  (log/info "Connecting to redis server..")
  (defmacro wcar* [& body] `(car/wcar redis-server-conf ~@body)))