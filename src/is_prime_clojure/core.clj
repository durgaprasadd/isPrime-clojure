(ns is-prime-clojure.core)

(defn my-is-prime?
  [number end total-parts start]
  (not (some zero?
             (map mod (repeat number)
                  (range start end total-parts)))))


(defn -main [& args]
  (let [number 67280421310721 cores 8 end (inc (Math/sqrt number))]
    (time
      (println
        (every? identity
                (doall (pmap
                         (partial my-is-prime? number end cores)
                         (range 2 (inc (inc cores))))))))))
