import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

extract :: [Double] -> Double
extract (x:[]) = x

show' :: String -> String
show' a = "VOLUME = " ++ a ++ "\n"

main = interact $ show' . (roundToStr 3) . (((4.0/3.0) * 3.14159) *) . (^3) . extract . map read . words 
