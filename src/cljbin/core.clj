(ns cljbin.core
  (:require [cljbin.system :refer [init-system start!]]))

(defn -main [& args]
  (init-system)
  (start!))