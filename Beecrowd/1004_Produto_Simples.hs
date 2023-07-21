show' :: (Show a) => a -> String
show' a = "PROD = " ++ show a ++ "\n"

main = interact $ show' . (foldl (*) 1) . map read . words
