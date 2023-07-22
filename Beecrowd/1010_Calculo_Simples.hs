import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: [Double] -> String
show' (_:y:z:_:b:c:_) = "VALOR A PAGAR: R$ " ++ (roundToStr 2 (y*z + b*c)) ++ "\n"

main = interact $ show' . map read . words
