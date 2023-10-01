isPrime :: Int -> Bool
isPrime n
    | n <= 1 = False
    | otherwise = not $ any (\a -> mod n a == 0) [2..sqrtX]
    where 
        sqrtX = floor (sqrt (fromIntegral n))
        
parsing :: Int -> [Int] -> String
parsing 0 _ = []
parsing a (x:xs)
    | isPrime x = "Prime\n" ++ parsing (a-1) xs
    | otherwise = "Not Prime\n" ++ parsing (a-1) xs
        
main = interact
       $ (\(x:xs) -> parsing x xs)
       . map read
       . words
