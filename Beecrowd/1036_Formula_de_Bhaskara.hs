import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

function :: [Double] -> String
function (a:b:c:_)
    | delta < 0 || a == 0 = "Impossivel calcular\n"
    | otherwise = "R1 = " ++ roundToStr 5 ((-1 * b + sqrt delta)/(2*a)) ++ "\nR2 = " ++ roundToStr 5 ((-1 * b - sqrt delta)/(2*a)) ++ "\n"
    where 
    delta = b^2 - 4*a*c
    
main = interact $ function . map read . words
