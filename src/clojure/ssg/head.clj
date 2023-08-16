(ns ssg.head)

(def page-head
  [:head
   [:link {:rel "stylesheet"
           :href "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.8.0/styles/hybrid.min.css"}]
   [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.8.0/highlight.min.js"}]
   [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.8.0/languages/clojure.min.js"}]
   [:link {:rel "stylesheet"
           :href "/styles.css"}]
   [:title "(wipdev-blog)"]])
