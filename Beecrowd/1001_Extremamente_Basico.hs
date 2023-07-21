show' :: (Show a) => a -> String
show' a = "X = " ++ show a ++ "\n"

main = interact $ show' . sum . map read . words
