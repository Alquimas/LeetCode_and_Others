function :: [Int] -> Int
function (x:xs) = foldl (+) 0 (map (\a -> if a == x then 1 else 0) xs)

main = interact
       $ (++"\n")
       . show
       . function
       . map read
       . words
