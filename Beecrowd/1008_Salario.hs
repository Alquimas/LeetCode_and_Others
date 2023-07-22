import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: [Double] -> String
show' (x:y:z:_) = "NUMBER = " ++ (roundToStr 0 x) ++ "\nSALARY = U$ " ++ (roundToStr 2 (y*z)) ++ "\n"

main = interact $ show' . map read . words
