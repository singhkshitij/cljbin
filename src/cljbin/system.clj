(ns cljbin.system
  (:require [com.stuartsierra.component :as component]
            [cljbin.server :as server]
            [cljbin.store :as store]
            [clojure.tools.logging :refer [error]]
            [clojure.tools.logging :as log]))

(def ^:redef system
  "Holds our system."
  nil)

(defn build-system
  "Defines our system map."
  []
  (try
    (-> (component/system-map
          :server (server/make-server)
          :store (store/make-store))
        (component/system-using {:server [:store]}))
    (catch Exception e
      (error "Failed to build system" e))))

(defn init-system
  []
  (let [sys (build-system)]
    (alter-var-root #'system (constantly sys))))

(defn stop!
  "Stop system"
  []
  (alter-var-root #'system component/stop-system))

(defn start!
  "Start system"
  []
  (alter-var-root #'system component/start-system)
  (log/info "System started ! Go put trash out there now..."))
