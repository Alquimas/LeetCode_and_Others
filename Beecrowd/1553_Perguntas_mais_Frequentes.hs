import Data.List

parsing :: [Int] -> String
parsing (0:0:_) = []
parsing (x:y:xs) = solve y (take x xs) ++ "\n" ++ parsing (drop x xs)

solve :: Int -> [Int] -> String
solve x xs = show (length $ filter test (group $ sort xs))
    where
        test y = (length y) >= x

main = interact
       $ parsing
       . map read
       . words
