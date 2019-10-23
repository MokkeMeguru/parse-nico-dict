(ns enlive-test.core-test
  (:require [clojure.test :refer :all]
            [enlive-test.core :refer :all]))

;; (deftest a-test
;;   (testing "FIXME, I fail."
;;     (is (= 0 0))))

;; (def example-article-item
;;   {:type :element,
;;    :attrs nil,
;;    :tag :p,
;;    :content
;;    [{:type :element,
;;      :attrs {:style "color: #000000;"},
;;      :tag :span,
;;      :content
;;      [{:type :element, :attrs nil, :tag :strong, :content ["株式会社アップランド"]}]}
;;     "とは、"
;;     {:type :element,
;;      :attrs {:class "auto-hdn", :href "/a/%E4%B8%BB"},
;;      :tag :a,
;;      :content ["主"]}
;;     "に"
;;     {:type :element,
;;      :attrs
;;      {:class "auto",
;;       :href "/a/%E3%83%90%E3%83%BC%E3%83%81%E3%83%A3%E3%83%ABYouTuber"},
;;      :tag :a,
;;      :content ["バーチャルYouTuber"]}
;;     {:type :element,
;;      :attrs
;;      {:class "auto",
;;       :href "/a/%E9%9B%BB%E8%84%B3%E5%B0%91%E5%A5%B3%E3%82%B7%E3%83%AD"},
;;      :tag :a,
;;      :content ["電脳少女シロ"]}
;;     "の活動で知られる"
;;     {:type :element,
;;      :attrs
;;      {:class "auto",
;;       :href
;;       "/a/%E3%82%B9%E3%83%9E%E3%83%BC%E3%83%88%E3%83%95%E3%82%A9%E3%83%B3"},
;;      :tag :a,
;;      :content ["スマートフォン"]}
;;     {:type :element,
;;      :attrs {:class "auto", :href "/a/%E3%82%A2%E3%83%97%E3%83%AA"},
;;      :tag :a,
;;      :content ["アプリ"]}
;;     "事業会社（？）である。"]})

;; (deftest parse-example-item-test
;;   (is (parse-example-item [example-article-item])))

;; (deftest flatten-string-test
;;   (is (flatten-string (parse-example-item [example-article-item]))))

;; (deftest concat-strs-test
;;   (is (concat-strs (flatten-string (parse-example-item [example-article-item])))))
