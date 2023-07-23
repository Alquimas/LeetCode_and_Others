cedulas :: [Int] -> Int -> String
cedulas [] _ = []
cedulas (1000:xs) a = show a ++ "\n" ++ cedulas xs a 
cedulas (x:xs) a = show c ++ " nota(s) de R$ " ++ show x ++ ",00\n" ++ cedulas xs b
    where 
        b = (mod a x)
        c = div (a - b) x

main = interact $ (cedulas [1000,100,50,20,10,5,2,1]) . (foldl1 (+)) . map read . words
