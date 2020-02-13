(ns is-prime-clojure.core)

(defn my-is-prime?
  [number end total-parts start]
  (some zero?
        (map mod (repeat number)
             (range start end total-parts))))


(defn -main [& args]
  (let [number 67280421310721 cores 8 end (inc (Math/sqrt number))
        (time
          (println
            (not
              (some deref
                    (doall (map
                             #(future (my-is-prime? number end cores %))
                             (range 2 (inc (inc cores)))))))))]))