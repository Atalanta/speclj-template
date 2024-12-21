(ns lordcope.speclj-test
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [clojure.test :refer :all]
            [org.corfield.new] ; for the Specs
            [lordcope.speclj :refer :all]))

(deftest valid-template-test
  (testing "template.edn is valid."
    (let [template (edn/read-string (slurp (io/resource "lordcope/speclj/template.edn")))]
      (is (s/valid? :org.corfield.new/template template)
          (s/explain-str :org.corfield.new/template template)))))