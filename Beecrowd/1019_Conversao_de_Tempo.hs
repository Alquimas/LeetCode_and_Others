convert :: [Int] -> Int -> String
convert [] _ = []
convert (x:[]) a = show a ++ "\n"
convert (x:xs) a = show c ++ ":" ++ convert xs b 
    where 
        b = mod a x
        c = div (a - b) x

main = interact $ (convert [3600,60,1]). (foldl1 (+)) . map read . words
