(ns cljbin.core
  (:gen-class)
  (:require [cljbin.system :refer [init-system start!]]))

(defn -main [& args]
  (init-system)
  (start!))