function :: [Int] -> String
function (a:b:_)
    | k == 0 = "O JOGO DUROU 24 HORA(S)\n"
    | otherwise = "O JOGO DUROU " ++ show k ++ " HORA(S)\n"
    where 
        k = mod (b - a) 24

main = interact $ function . map read . words
