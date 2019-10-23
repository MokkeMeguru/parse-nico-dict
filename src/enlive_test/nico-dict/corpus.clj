(ns enlive-test.nico-dict.corpus
  (:require [clojure.string :refer [trim blank? split]]
            [clj-http.client :as client]
            [hickory.select :as s]
            [enlive-test.utils :refer :all])
  (:use [hickory.core]
        [hickory.render]))

