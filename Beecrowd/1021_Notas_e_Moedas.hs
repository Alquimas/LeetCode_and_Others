import Text.Printf

convertionList = [100000,10000,5000,2000,1000,500,200,0,100,50,25,10,5,1]

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

cedulas :: [Int] -> Int -> String
cedulas [] _ = []
cedulas (100000:xs) a = "NOTAS:\n" ++ cedulas xs a
cedulas (0:xs) a = "MOEDAS:\n" ++ moedas xs a
cedulas (x:xs) a = show c ++ " nota(s) de R$ " ++ (roundToStr 2 z) ++ "\n" ++ cedulas xs b
    where
        c = div a x
        b = a - c * x
        y = (fromIntegral x) :: Float 
        z = y / 100

moedas :: [Int] -> Int -> String
moedas [] _ = []
moedas (x:xs) a = show c ++ " moeda(s) de R$ " ++ (roundToStr 2 z) ++ "\n" ++ moedas xs b
    where
        c = div a x
        b = a - c * x
        y = (fromIntegral x) :: Float
        z = y / 100

main = interact $ (cedulas convertionList) . (floor) . (*100) . (foldl1 (+)) . map read . words
