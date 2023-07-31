import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

isTriangle :: Double -> Double -> Double -> Bool
isTriangle a b c
    | a >= b + c = False
    | b >= a + c = False
    | c >= a + b = False
    | otherwise = True
    
function :: [Double] -> String 
function (x:y:z:_)
    | isTriangle x y z = "Perimetro = " ++ roundToStr 1 (x + y + z) ++ "\n"
    | otherwise = "Area = " ++ roundToStr 1 ((x + y) * z * 0.5) ++ "\n"

main = interact $ function . map read . words
