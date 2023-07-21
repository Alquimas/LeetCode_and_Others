import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: String -> String
show' a = "MEDIA = " ++ a ++ "\n"

read' :: String -> Double
read' a = read a

med :: [Double] -> Double
med (x:y:_) = (x*3.5 + y*7.5)/11.0

main = interact $ show' . (roundToStr 5) . med . (map read') . words 
