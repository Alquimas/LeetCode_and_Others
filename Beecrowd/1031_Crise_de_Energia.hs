function :: [Int] -> String
function [0] = []
function (x:xs) = go x ++ "\n" ++ function xs
    where
        go x = show . head $ dropWhile (test x) [1..]

test :: Int -> Int -> Bool
test x y = (2 + (outp (x - 1) y)) /= 13

outp :: Int -> Int -> Int
outp 1 _ = 0
outp a k = mod (k + outp (a - 1) k) a

main = interact
       $ function
       . map read
       . words
