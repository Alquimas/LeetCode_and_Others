function :: [Double] -> String
function (a:_)
    | 0 <= a && 25 >= a = "Intervalo [0,25]\n"
    | 25 < a && 50 >= a = "Intervalo (25,50]\n"
    | 50 < a && 75 >= a = "Intervalo (50,75]\n"
    | 75 < a && 100 >= a = "Intervalo (75,100]\n"
    | otherwise = "Fora de intervalo\n"
    
main = interact $ function . map read . words
