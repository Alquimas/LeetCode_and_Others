import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr a b = (printf "%0.*f" a b) ++ " km/l\n"

calc :: [Double] -> Double
calc (x:y:_) = x / y

main = interact $ (roundToStr 3) . calc . map read . words
