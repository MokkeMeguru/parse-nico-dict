(ns enlive-test.utils
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
