
(deftest read-integer
  (is (= {:head :integer, :value 42} (read-string "42")))
  (is (= {:head :integer, :value 42} (read-string "+42")))
  (is (= {:head :integer, :value -42} (read-string "-42")))

  (is (= {:head :integer, :value 42N} (read-string "42N")))
  (is (= {:head :integer, :value 42N} (read-string "+42N")))
  (is (= {:head :integer, :value -42N} (read-string "-42N")))

  (is (= {:head :integer, :value 0} (read-string "0")))
  (is (= {:head :integer, :value 0N} (read-string "0N")))

  (is (= {:head :integer, :value 042} (read-string "042")))
  (is (= {:head :integer, :value +042} (read-string "+042")))
  (is (= {:head :integer, :value -042} (read-string "-042")))

  (is (= {:head :integer :value 0x42e} (read-string "0x42e")))
  (is (= {:head :integer :value +0x42e} (read-string "+0x42e")))
  (is (= {:head :integer :value -0x42e} (read-string "-0x42e")))

  (is (instance? Long (:value (read-string "2147483647"))))
  (is (instance? Long (:value (read-string "+1"))))
  (is (instance? Long (:value (read-string "1"))))
  (is (instance? Long (:value (read-string "+0"))))
  (is (instance? Long (:value (read-string "0"))))
  (is (instance? Long (:value (read-string "-0"))))
  (is (instance? Long (:value (read-string "-1"))))
  (is (instance? Long (:value (read-string "-2147483648"))))

  (is (instance? Long (:value (read-string "2147483648"))))
  (is (instance? Long (:value (read-string "-2147483649"))))
  (is (instance? Long (:value (read-string "9223372036854775807"))))
  (is (instance? Long (:value (read-string "-9223372036854775808"))))

  (is (instance? BigInt (:value (read-string "9223372036854775808"))))
  (is (instance? BigInt (:value (read-string "-9223372036854775809"))))
  (is (instance? BigInt (:value (read-string "10000000000000000000000000000000000000000000000000"))))
  (is (instance? BigInt (:value (read-string "-10000000000000000000000000000000000000000000000000")))))

(deftest read-floating
  (is (= {:head :float, :value 42.23} (read-string "42.23")))
  (is (= {:head :float, :value +42.23} (read-string "+42.23")))
  (is (= {:head :float, :value -42.23}  (read-string "-42.23")))

  (is (= {:head :float, :value 42.23M}  (read-string "42.23M")))
  (is (= {:head :float, :value +42.23M}  (read-string "+42.23M")))
  (is (= {:head :float, :value -42.23M}  (read-string "-42.23M")))

  (is (= {:head :float, :value 42.2e3} (read-string "42.2e3")))
  (is (= {:head :float, :value 42.2e+3}  (read-string "+42.2e+3")))
  (is (= {:head :float, :value -42.2e-3}  (read-string "-42.2e-3")))

  (is (= {:head :float, :value 42.2e3M}  (read-string "42.2e3M")))
  (is (= {:head :float, :value +42.2e+3M}  (read-string "+42.2e+3M")))
  (is (= {:head :float, :value -42.2e-3M} (read-string "-42.2e-3M")))

  (is (instance? Double (:value (read-string "+1.0e+1"))))
  (is (instance? Double (:value (read-string "+1.e+1"))))
  (is (instance? Double (:value (read-string "+1e+1"))))

  (is (instance? Double (:value (read-string "+1.0e+1"))))
  (is (instance? Double (:value (read-string "+1.e+1"))))
  (is (instance? Double (:value (read-string "+1e+1"))))

  (is (instance? Double (:value (read-string "+1.0e1"))))
  (is (instance? Double (:value (read-string "+1.e1"))))
  (is (instance? Double (:value (read-string "+1e1"))))

  (is (instance? Double (:value (read-string "+1.0e-1"))))
  (is (instance? Double (:value (read-string "+1.e-1"))))
  (is (instance? Double (:value (read-string "+1e-1"))))

  (is (instance? Double (:value (read-string "1.0e+1"))))
  (is (instance? Double (:value (read-string "1.e+1"))))
  (is (instance? Double (:value (read-string "1e+1"))))

  (is (instance? Double (:value (read-string "1.0e-1"))))
  (is (instance? Double (:value (read-string "1.e-1"))))
  (is (instance? Double (:value (read-string "1e-1"))))

  (is (instance? Double (:value (read-string "-1.0e+1"))))
  (is (instance? Double (:value (read-string "-1.e+1"))))
  (is (instance? Double (:value (read-string "-1e+1"))))

  (is (instance? Double (:value (read-string "-1.0e1"))))
  (is (instance? Double (:value (read-string "-1.e1"))))
  (is (instance? Double (:value (read-string "-1e1"))))

  (is (instance? Double (:value (read-string "-1.0e-1"))))
  (is (instance? Double (:value (read-string "-1.e-1"))))
  (is (instance? Double (:value (read-string "-1e-1"))))

  (is (instance? Double (:value (read-string "+1.0"))))
  (is (instance? Double (:value (read-string "+1."))))

  (is (instance? Double (:value (read-string "1.0"))))
  (is (instance? Double (:value (read-string "1."))))

  (is (instance? Double (:value (read-string "+0.0"))))
  (is (instance? Double (:value (read-string "+0."))))

  (is (instance? Double (:value (read-string "0.0"))))
  (is (instance? Double (:value (read-string "0."))))

  (is (instance? Double (:value (read-string "-0.0"))))
  (is (instance? Double (:value (read-string "-0."))))

  (is (instance? Double (:value (read-string "-1.0"))))
  (is (instance? Double (:value (read-string "-1."))))

  (is (instance? BigDecimal (:value (read-string "9223372036854775808M"))))
  (is (instance? BigDecimal (:value (read-string "-9223372036854775809M"))))
  (is (instance? BigDecimal (:value (read-string "2147483647M"))))
  (is (instance? BigDecimal (:value (read-string "+1M"))))
  (is (instance? BigDecimal (:value (read-string "1M"))))
  (is (instance? BigDecimal (:value (read-string "+0M"))))
  (is (instance? BigDecimal (:value (read-string "0M"))))
  (is (instance? BigDecimal (:value (read-string "-0M"))))
  (is (instance? BigDecimal (:value (read-string "-1M"))))
  (is (instance? BigDecimal (:value (read-string "-2147483648M"))))

  (is (instance? BigDecimal (:value (read-string "+1.0e+1M"))))
  (is (instance? BigDecimal (:value (read-string "+1.e+1M"))))
  (is (instance? BigDecimal (:value (read-string "+1e+1M"))))

  (is (instance? BigDecimal (:value (read-string "+1.0e1M"))))
  (is (instance? BigDecimal (:value (read-string "+1.e1M"))))
  (is (instance? BigDecimal (:value (read-string "+1e1M"))))

  (is (instance? BigDecimal (:value (read-string "+1.0e-1M"))))
  (is (instance? BigDecimal (:value (read-string "+1.e-1M"))))
  (is (instance? BigDecimal (:value (read-string "+1e-1M"))))

  (is (instance? BigDecimal (:value (read-string "1.0e+1M"))))
  (is (instance? BigDecimal (:value (read-string "1.e+1M"))))
  (is (instance? BigDecimal (:value (read-string "1e+1M"))))

  (is (instance? BigDecimal (:value (read-string "1.0e1M"))))
  (is (instance? BigDecimal (:value (read-string "1.e1M"))))
  (is (instance? BigDecimal (:value (read-string "1e1M"))))

  (is (instance? BigDecimal (:value (read-string "1.0e-1M"))))
  (is (instance? BigDecimal (:value (read-string "1.e-1M"))))
  (is (instance? BigDecimal (:value (read-string "1e-1M"))))

  (is (instance? BigDecimal (:value (read-string "-1.0e+1M"))))
  (is (instance? BigDecimal (:value (read-string "-1.e+1M"))))
  (is (instance? BigDecimal (:value (read-string "-1e+1M"))))

  (is (instance? BigDecimal (:value (read-string "-1.0e1M"))))
  (is (instance? BigDecimal (:value (read-string "-1.e1M"))))
  (is (instance? BigDecimal (:value (read-string "-1e1M"))))

  (is (instance? BigDecimal (:value (read-string "-1.0e-1M"))))
  (is (instance? BigDecimal (:value (read-string "-1.e-1M"))))
  (is (instance? BigDecimal (:value (read-string "-1e-1M"))))

  (is (instance? BigDecimal (:value (read-string "+1.0M"))))
  (is (instance? BigDecimal (:value (read-string "+1.M"))))

  (is (instance? BigDecimal (:value (read-string "1.0M"))))
  (is (instance? BigDecimal (:value (read-string "1.M"))))

  (is (instance? BigDecimal (:value (read-string "+0.0M"))))
  (is (instance? BigDecimal (:value (read-string "+0.M"))))

  (is (instance? BigDecimal (:value (read-string "0.0M"))))
  (is (instance? BigDecimal (:value (read-string "0.M"))))

  (is (instance? BigDecimal (:value (read-string "-0.0M"))))
  (is (instance? BigDecimal (:value (read-string "-0.M"))))

  (is (instance? BigDecimal (:value (read-string "-1.0M"))))
  (is (instance? BigDecimal (:value (read-string "-1.M")))))

(deftest read-ratio
  (is (= {:head :ratio, :body [{:head :integer, :value 5} {:head :integer, :value 2}]} (read-string "5/2")))
  (is (= {:head :ratio, :body [{:head :integer, :value 5} {:head :integer, :value 2}]} (read-string "+5/2")))
  (is (= {:head :ratio, :body [{:head :integer, :value -5} {:head :integer, :value 2}]} (read-string "-5/2"))))


(deftest read-symbol
  (is (= '{:head :symbol, :value foo} (read-string "foo")))
  (is (= '{:head :symbol, :value foo/bar} (read-string "foo/bar")))
  (is (= '{:head :symbol, :value *+!-_?} (read-string "*+!-_?")))
  (is (= '{:head :symbol, :value abc:def:ghi} (read-string "abc:def:ghi")))
  (is (= '{:head :symbol, :value abc.def/ghi} (read-string "abc.def/ghi")))
  (is (= '{:head :symbol, :value abc/def.ghi} (read-string "abc/def.ghi")))
  (is (= '{:head :symbol, :value abc:def/ghi:jkl.mno} (read-string "abc:def/ghi:jkl.mno")))
  (is (instance? clojure.lang.Symbol (:value (read-string "alphabet"))))
  (is (= "foo//" (str (:value (read-string "foo//"))))) ;; the clojure reader can't read this
  (is (= (str 'NaN) (str (:value (read-string "NaN"))))) ;; the clojure reader can't read this
  (is (= {:head :positive-infinity, :value Double/POSITIVE_INFINITY}  (read-string "Infinity"))) ;; the clojure reader can't read this
  (is (= {:head :positive-infinity, :value Double/POSITIVE_INFINITY}  (read-string "+Infinity"))) ;; the clojure reader can't read this
  (is (= {:head :negative-infinity, :value Double/NEGATIVE_INFINITY}  (read-string "-Infinity")))) ;; the clojure reader can't read this

(deftest read-specials
  (is (= '{:head :nil, :value nil} (read-string "nil")))
  (is (= '{:head :boolean, :value false} (read-string "false")))
  (is (= '{:head :boolean, :value true} (read-string "true"))))

(deftest read-char
  (is (= {:head :character, :value \f} (read-string "\\f")))
  (is (= {:head :character, :value \u0194}  (read-string "\\u0194")))
  (is (= {:head :character, :value \a} (read-string "\\x61"))) ;; the clojure reader can't read this
  (is (= {:head :character, :value  \o123} (read-string "\\o123")))
  (is (= {:head :character, :value \newline }  (read-string "\\newline")))
  (is (= {:head :character, :value  (char 0) } (read-string "\\o0")))
  (is (= {:head :character, :value (char 0) }  (read-string "\\o000")))
  (is (= {:head :character, :value (char 0377) }  (read-string "\\o377")))
  (is (= {:head :character, :value \A }  (read-string "\\u0041")))
  (is (= {:head :character, :value \@ }  (read-string "\\@")))
  (is (= {:head :character, :value (char 0xd7ff)}  (read-string "\\ud7ff")))
  (is (= {:head :character, :value (char 0xe000) }  (read-string "\\ue000")))
  (is (= {:head :character, :value (char 0xffff)} (read-string "\\uffff"))))

(deftest read-string*
  (is (= {:head :string, :value "foo bar"}  (read-string "\"foo bar\"")))
  (is (= {:head :string, :value "foo\\bar"} (read-string "\"foo\\\\bar\"")))
  (is (= {:head :string, :value "foo\000bar"} (read-string "\"foo\\000bar\"")))
  (is (= {:head :string, :value "foo\u0194bar"}  (read-string "\"foo\\u0194bar\"")))
  (is (= {:head :string, :value  "fooabar" } (read-string "\"foo\\x61bar\""))) ;; the clojure reader can't read this
  (is (= {:head :string, :value "foo\123bar"}  (read-string "\"foo\\123bar\""))))

(deftest read-list
  (is (= '{:head :list, :body []} (read-string "()")))
  (is (= '{:head :list, :body [{:head :symbol, :value foo} {:head :symbol, :value bar}]} (read-string "(foo bar)")))
  (is (= '{:head :list, :body [{:head :symbol, :value foo} {:head :list, :body [{:head :symbol, :value bar}]} {:head :symbol, :value baz}]} (read-string "(foo (bar) baz)"))))

(deftest read-vector
  (is (= '{:head :vector, :body []} (read-string "[]")))
  (is (= '{:head :vector, :body [{:head :symbol, :value foo} {:head :symbol, :value bar}]} (read-string "[foo bar]")))
  (is (= '{:head :vector, :body [{:head :symbol, :value foo} {:head :vector, :body [{:head :symbol, :value bar}]} {:head :symbol, :value baz}]} (read-string "[foo [bar] baz]"))))

(deftest read-map
  (is (= '{:head :map, :body []} (read-string "{}")))
  (is (= '{:head :map, :body [{:head :symbol, :value foo} {:head :symbol, :value bar}]} (read-string "{foo bar}")))
  (is (= '{:head :map, :body [{:head :symbol, :value foo} {:head :map, :body [{:head :symbol, :value bar} {:head :symbol, :value baz}]}]} (read-string "{foo {bar baz}}"))))

(deftest read-set
  (is (= '{:head :set, :body []} (read-string "#{}")))
  (is (= '{:head :set, :body [{:head :symbol, :value foo} {:head :symbol, :value bar}]} (read-string "#{foo bar}")))
  (is (= '{:head :set, :body [{:head :symbol, :value foo} {:head :set, :body [{:head :symbol, :value bar}]} {:head :symbol, :value baz}]} (read-string "#{foo #{bar} baz}"))))

(deftest read-metadata
  (is (= '{:head :meta, :body [{:head :keyword, :value :foo} {:head :quote, :body [{:head :symbol, :value bar}]}]} (read-string "^:foo 'bar")))
  (is (= '{:head :meta, :body [{:head :map, :body [{:head :keyword, :value :foo} {:head :symbol, :value bar}]} {:head :quote, :body [{:head :symbol, :value baz}]}]} (read-string "^{:foo bar} 'baz")))
  (is (= '{:head :meta, :body [{:head :string, :value "foo"} {:head :quote, :body [{:head :symbol, :value bar}]}]} (read-string "^\"foo\" 'bar")))
  (is (= '{:head :meta, :body [{:head :symbol, :value String} {:head :quote, :body [{:head :symbol, :value x}]}]} (read-string "^String 'x"))))
