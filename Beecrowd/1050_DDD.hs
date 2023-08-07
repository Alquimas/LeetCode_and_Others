function :: Int -> String
function a
    | a == 11 = "Sao Paulo"
    | a == 61 = "Brasilia"
    | a == 71 = "Salvador"
    | a == 21 = "Rio de Janeiro"
    | a == 32 = "Juiz de Fora"
    | a == 19 = "Campinas"
    | a == 27 = "Vitoria"
    | a == 31 = "Belo Horizonte"
    | otherwise = "DDD nao cadastrado"

main = interact
       $ (++"\n")
       . function
       . (\(x:_) -> x)
       . map read
       . words
