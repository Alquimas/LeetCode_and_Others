function :: [Double] -> String
function (a:b:_) 
    | (a > 0) && (b > 0) = "Q1\n"
    | (a < 0) && (b > 0) = "Q2\n"
    | (a < 0) && (b < 0) = "Q3\n"
    | (a > 0) && (b < 0) = "Q4\n"
    | (a == 0) && (b == 0) = "Origem\n"
    | (a == 0) = "Eixo Y\n"
    | (b == 0) = "Eixo X\n"    

main = interact $ function . map read . words
