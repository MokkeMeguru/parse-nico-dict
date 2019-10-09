(ns enlive-test.core
  (:require [clojure.string :refer [trim blank? split]]
            [clj-http.client :as client]
            [hickory.select :as s])
  (:use [hickory.core]
        [hickory.render]))

;; ------ default utility ------------------

(defn trim-by-content
  "trim string elements
  ex. \"      hello      \" ->  \"hello\" "
  [d]
  (let [_content (:content d)]
    (if (nil? _content)
      d
      (update d :content
              #(->> %
                    (map (fn [e]
                           (cond
                             (string? e) (trim e)
                             (map? e) (trim-by-content e)
                             :default e)))
                    (filter (fn [e] (or  (not (string? e)) (not (blank? e)))))
                    vec)))))

(defn read-html-from-url [url]
  (-> (client/get url) :body parse as-hickory trim-by-content))

(defn read-html-from-file [fname]
  (-> fname clojure.java.io/resource slurp parse as-hickory trim-by-content))

;; --------------------------------------------------

;; ------ for niconico dict --------------------

(defn read-html-from-url-n [url]
  (let [raw (->> (read-html-from-url url)
                 ;;  raw の 子要素の、tag が html である要素の子要素
                 (s/select
                  (s/child
                   (s/tag :html)))
                 first)
        head (->> raw
                  ;; tag が head であるものの第一要素を取り出す。
                  (s/select
                   (s/child
                    (s/tag :head)))
                  first)
        title (->> head
                   ;;  head の 子要素の、tag が title である最初の要素を取り出す
                   (s/select
                    (s/child
                     (s/tag :title)
                     (s/child)))
                   first)
        keywords (-> (->> head
                             ;;  head の 子要素の、attr の name  が keywords である最初の要素を取り出す
                          (s/select
                           (s/child
                            (s/attr :name #(= % "keywords"))))
                          first)
                     :attrs
                     :content
                     (split #","))
        body
        (->> raw
             (s/select
              (s/child
               (s/tag :html)
               (s/child)))
             second
             (s/select
              (s/child
               (s/and (s/tag :div)
                      (s/attr :id #(= "container" %)))))
             first)
        bbody (->> body
                   (s/select
                    (s/child
                     (s/node-type :element)
                     (s/tag :div)
                     s/first-child)))]

    {:title title
     :keywords keywords
     ;; :body body
     :bbody (map #(:tag %) bbody)}))
;;  html

