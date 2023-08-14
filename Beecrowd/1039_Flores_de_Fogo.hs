distance :: Double -> Double -> Double -> Double -> Double
distance a b c d = sqrt( (a - c)^2 + (b - d)^2 )

function :: [Double] -> String
function [] = []
function (r1:a:b:r2:c:d:xs)
    | distance a b c d + r2 > r1 = "MORTO\n" ++ function xs
    | otherwise = "RICO\n" ++ function xs

main = interact
       $ function
       . map read
       . words
