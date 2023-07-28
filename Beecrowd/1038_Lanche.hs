import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

show' :: Double -> String
show' a = "Total: R$ " ++ roundToStr 2 a ++ "\n"

function :: [Int] -> Double
function (x:y:_)
    | x == 1 = 4.0*z
    | x == 2 = 4.5*z
    | x == 3 = 5.0*z
    | x == 4 = 2.0*z
    | x == 5 = 1.5*z
    where 
        z = fromIntegral y

main = interact $ show' . function . map read . words
