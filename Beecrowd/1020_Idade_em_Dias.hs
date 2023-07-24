convert :: Int -> String
convert a = show x ++ " ano(s)\n" ++ show y ++ " mes(es)\n" ++ show z ++ " dia(s)\n" 
    where 
        x = div a 365
        y = div (a - x*365) 30
        z = (a - x*365 - y*30)

main = interact $ convert . (foldl (+) 0) . map read . words
