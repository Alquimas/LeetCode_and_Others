parsing :: [Int] -> String
parsing (0:0:0:0:_) = []
parsing (x:y:z:w:xs) = show b ++ "\n" ++ parsing xs
    where
        a = mod (z*60 + w - x*60 - y) 1440
        b = if (a == 0) then 1440 else a

main = interact
       $ parsing
       . map read
       . words
