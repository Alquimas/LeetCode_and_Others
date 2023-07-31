import Data.List

function2 :: [Double] -> String
function2 (x:y:z:_)
    | (x == y) && (y == z) = "TRIANGULO EQUILATERO\n"
    | (x == y) || (y == z) || (x == z) = "TRIANGULO ISOSCELES\n"
    | otherwise = []

function :: [Double] -> String
function all@(x:y:z:_)
    | z >= y + x = "NAO FORMA TRIANGULO\n"
    | z^2 == y^2 + x^2 = "TRIANGULO RETANGULO\n" ++ function2 all
    | z^2 > y^2 + x^2 = "TRIANGULO OBTUSANGULO\n" ++ function2 all
    | z^2 < y^2 + x^2 = "TRIANGULO ACUTANGULO\n" ++ function2 all

main = interact $ function . sort . map read . words
