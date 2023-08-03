function :: [Int] -> String
function (a:b:c:d:_) 
    | k == 0 = "O JOGO DUROU 24 HORA(S) E 0 MINUTO(S)\n"
    | otherwise = "O JOGO DUROU " ++ show a1 ++ " HORA(S) E " ++ show a2 ++ " MINUTO(S)\n"
    where
        k = mod (-60*a - b + 60*c + d) 1440
        a1 = div k 60
        a2 = mod k 60
main = interact $ function . map read . words
