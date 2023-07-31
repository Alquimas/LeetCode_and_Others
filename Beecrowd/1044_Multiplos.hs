function :: [Int] -> String
function (x:y:_)
    | (mod x y == 0) || (mod y x == 0) = "Sao Multiplos\n"
    | otherwise = "Nao sao Multiplos\n"

main = interact $ function . map read . words
