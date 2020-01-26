(ns cljbin.view
  (:require [hiccup.page :refer [html5 include-js include-css]]
            [hiccup.form :refer [form-to text-area submit-button]]))

(defn render-paste
  "Given a map representing a paste, return an HTML string for the display of a paste."
  [paste]
  (html5 [:head
          (include-js "https://sos-de-fra-1.exo.io/highlight.js/9.12.0/highlight.min.js")
          (include-js "https://sos-de-fra-1.exo.io/highlight.js/9.12.0/go.min.js")
          (include-js "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.10/languages/clojure.min.js")
          (include-js "https://cdnjs.cloudflare.com/ajax/libs/highlightjs-line-numbers.js/2.7.0/highlightjs-line-numbers.min.js")
          (include-js "https://sos-de-fra-1.exo.io/highlight.js/9.12.0/yaml.min.js")
          (include-css "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.15.10/styles/dracula.min.css")
          [:title "Clojure bin"]
          [:meta {:charset "UTF-8"}]
          [:script "hljs.initHighlightingOnLoad();
                    hljs.initLineNumbersOnLoad();"]]
         [:body
          [:style "body {background:#2c3e50; color:#fff; padding:20px 50px; margin:0; height: 92%; width:92% }
                   pre {background: 0 0}
                   .hljs-ln-n {padding-right: 10px;}
                   .hljs {background:#2c3e50}"]
          [:pre {:class "hljs"}
           [:code paste]]]))

(defn render-form
  "Render a simple HTML form page."
  []
  (html5 [:head
          [:title "Clojure bin"]
          [:style "html {height:100%; width:93%}"]
          [:meta {:charset "UTF-8"}]]
         [:body
          [:style "body {background:#2c3e50; color:#fff; padding:20px 50px; margin:0; height: 92%; width:100% }
                   form {height:100%; width:100%}
                   input {font-size: xx-large; height:50px; width:50px; border-radius:50px; margin:2px; background: #2980b9; color: #fff; float:right; transition: background-color .3s; box-shadow: 0 1px 4px rgba(0, 0, 0, .6); outline: none; border-width: 0;}
                   input:hover {background-color: #3498db;}
                   textarea {overflow:hidden; background: 0 0; border:0; color:#fff; padding:0; width:100%; height:90%; font-family:monospace; outline:none; resize:none; font-size:13px;}"]
          (form-to [:post "/"]
                   (text-area {} "content")
                   [:div {:style "color: #fff;z-index: -1000;position: absolute;top: 20px;left: 0;width: 30px;font-size: 13px;text-align: right;"}
                    ">"]
                   [:div
                    (submit-button "+")]
                   )]))