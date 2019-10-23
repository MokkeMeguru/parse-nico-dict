(ns enlive-test.core
  (:require
   [clojure.data.json :as json]
   [enlive-test.nico-dict.web :as nw]))


(defn parse-nicodict-web [url fname]
  (with-open [writer (clojure.java.io/writer fname ::encoding "UTF-8")]
    (.write writer (json/write-str (nw/read-to-parsed url)))))

;; example
;; (parse-nicodict-web "https://dic.nicovideo.jp/a/アップランド" "./resources/アップランド.json")
