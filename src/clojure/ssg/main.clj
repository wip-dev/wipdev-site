(ns ssg.main
  (:require [clojure.java.io :refer [file]]
            [clojure.string :as s]
            [clojure.java.shell :refer [sh]]
            [markdown.core :as md]
            [hiccup2.core :as h]))

(def md->hiccup (comp h/raw md/md-to-html-string))

(defn post-html-target
  [md-file]
  (-> (.getPath md-file)
      (#(s/replace % #"src/content" "public"))
      (#(s/replace % #".md" ".html"))))

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

(defn make-content
  [file]
  {:target (post-html-target file)
   :content ((comp wrap-post md->hiccup slurp) file)})

(defn -main
  []
  (let [files    (filter #(not (.isDirectory %))
                         (file-seq (file "src/content/")))
        contents (map make-content files)]
    (sh "find" "public/" "-name" "*.html" "-type" "f" "-delete")
    (println "Removed HTML files in `public/`")
    (doseq [{target :target content :content} contents]
      (spit target content)
      (println "Wrote " target))))
