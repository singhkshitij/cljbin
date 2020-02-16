(defproject cljbin "0.1.0"
  :description "A clojure bin service with syntax validation"
  :url "https://github.com/singhkshitij/cljbin"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [aleph "0.4.6"]
                 [hiccup "1.0.5"]
                 [bidi "2.1.3"]
                 [com.taoensso/carmine "2.19.1"]
                 [nano-id "0.10.0"]]
  :plugins [[lein-heroku "0.5.3"]]
  :main cljbin.core
  :aot [cljbin.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :heroku {:app-name "damp-hollows-89882"})
