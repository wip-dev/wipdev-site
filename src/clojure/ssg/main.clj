(ns ssg.main
  (:require [clojure.java.io :refer [file]]
            [clojure.string :refer [replace]]
            [markdown.core :as md]
            [hiccup2.core :as h]))

(def md->hiccup (comp h/raw md/md-to-html-string))

(defn make-html-path
  [md-file]
  (-> (.getPath md-file)
      (#(replace % #"src/content" "public"))
      (#(replace % #".md" ".html"))))

(defn wrap-post
  [post-html]
  (str "<!DOCTYPE html>"
       (h/html
        [:html
         [:head
          [:link {:rel "stylesheet" :href "/styles.css"}]]
         [:body
          [:article
           post-html]]])))

(defn -main
  []
  (let [files        (filter #(not (.isDirectory %))
                             (file-seq (file "src/content/")))
        targets      (map make-html-path
                          files)
        html-content (map (comp wrap-post md->hiccup slurp)
                          files)]
    (println html-content)
    (map spit targets html-content)))
