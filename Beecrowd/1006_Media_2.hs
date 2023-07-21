import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: String -> String
show' a = "MEDIA = " ++ a ++ "\n"

read' :: String -> Double
read' a = read a

med :: [Double] -> Double
med (x:y:z:_) = (x*2 + y*3 + z*5)/10.0

main = interact $ show' . (roundToStr 1) . med . (map read') . words 
