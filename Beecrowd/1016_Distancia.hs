main = interact $ (++ " minutos\n") . show . (*2) . (foldl (+) 0) . map read . words
