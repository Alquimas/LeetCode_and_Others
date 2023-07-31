function :: [Integer] -> String
function [] = []
function (x:xs) = show a ++ " kg\n" ++ function xs
    where
        a = div (2^x - 1) 12000

main = interact $ function . map read . tail . words
