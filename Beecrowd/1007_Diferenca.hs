show' :: (Show a) => a -> String
show' a = "DIFERENCA = " ++ show a ++ "\n"

diferenca :: [Int] -> Int
diferenca (x:y:z:w:_) = (x*y - z*w)

main = interact $ show' . diferenca . (map read) . words 
