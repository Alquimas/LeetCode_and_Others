function :: [Int] -> String
function (a:b:c:d:_)
    | (b > c) && (d > a) && (c + d) > (a + b) && (c > 0) && (d > 0) && (mod a 2 == 0) = "Valores aceitos\n"
    | otherwise = "Valores nao aceitos\n"

main = interact $ function . map read . words
