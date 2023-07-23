import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

distance :: [Double] -> Double
distance (x:y:z:w:_) = sqrt((x - z)^2 + (y - w)^2) 

main = interact $ (++"\n") . (roundToStr 4) . distance . map read . words
