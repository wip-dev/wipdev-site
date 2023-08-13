(ns blog.ssg
  (:require [markdown.core :as md]))

(slurp (clojure.java.io/file "src/blog/posts/what-got-me-here.md"))

(md/md-to-html
 "src/blog/posts/what-got-me-here.md"
 "public/posts/what-got-me-here.html")

(defn -main
  []
  (println markdown.core/md-to-html))
