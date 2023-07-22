import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: [Double] -> String
show' (x:y:_) = "TOTAL = R$ " ++ (roundToStr 2 (x + 0.15*y)) ++ "\n"

main = interact $ show' . map read . tail . words
