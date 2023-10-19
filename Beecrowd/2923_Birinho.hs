import Control.Arrow

solve :: [Int] -> String
solve [] = []
solve (x:y:z:w:xs)
    | (div (100*y) x) >= w = "critical\n" ++ solve xs
    | (div (100*y) x) >= z = "warning\n" ++ solve xs
    | otherwise = "OK\n" ++ solve xs

main = interact 
       $ words 
       >>> map read
       >>> solve
