import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

extract :: [Double] -> Double
extract (x:[]) = x

show' :: String -> String
show' a = "A=" ++ a ++ "\n"

main = interact $ show' . (roundToStr 4) . ((3.14159) *) . (^2) . extract . map read . words 
