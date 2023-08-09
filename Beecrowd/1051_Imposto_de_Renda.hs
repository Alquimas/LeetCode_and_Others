import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

function :: [Double] -> String
function (a:_)
    | a < 2000.0 = "Isento"
    | a < 3000.0 = "R$ " ++ roundToStr 2 ((a - 2000)*(0.08))
    | a < 4500.0 = "R$ " ++ roundToStr 2 ((a - 3000)*(0.18) + 80)
    | otherwise = "R$ " ++ roundToStr 2 ((a - 4500)*(0.28) + 350)

main = interact 
       $ (++"\n")
       . function
       . map read
       . words
