show' :: (Show a) => a -> String
show' a = "SOMA = " ++ show a ++ "\n"

main = interact $ show' . sum . map read . words
