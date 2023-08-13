function :: [Int] -> String
function (0:0:0:0:_) = []
function (a:b:c:d:xs)
    | (a == c) && (b == d) = "0\n" ++ function xs 
    | (a == c) || (b == d) = "1\n" ++ function xs
    | (a - c) == (b - d) = "1\n" ++ function xs
    | (a - c) == -1*(b - d) = "1\n" ++ function xs
    | otherwise = "2\n" ++ function xs

main = interact
       $ function
       . map read
       . words
