positiveMod :: Int -> Int -> Int
positiveMod a b 
    | mod a b == 0 = 0
    | otherwise = (mod a b) + abs b
    
positiveDiv :: Int -> Int -> Int
positiveDiv a b 
    | mod a b == 0 = div a b 
    | otherwise = (div a b + 1)

function :: [Int] -> String
function (a:b:_)
    | b > 0 = show (div a b) ++ " " ++ show ((mod a b))
    | b < 0 = show (positiveDiv a b) ++ " " ++ show (positiveMod a b)

main = interact $ (++"\n") . function . map read . words
