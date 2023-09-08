(ns ssg.menu)

(def page-menu
  [:aside
   [:pre {:id "logo"} [:code "(wipdev-blog)"]]
   [:ul
    [:li [:a {:href "/"} "Home/About"]]
    [:li [:a {:href "/posts"} "Articles"]]]])
