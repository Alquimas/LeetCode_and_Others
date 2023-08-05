import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

print' :: Double -> Double -> String
print' a b = "Novo salario: " ++ roundToStr 2 (a + a*b) ++ "\nReajuste ganho: " ++ roundToStr 2 (a*b) ++ "\nEm percentual: " ++ roundToStr 0 (100*b) ++ " %\n" 

function :: [Double] -> String
function (a:_)
    | a <= 400.0 = print' a 0.15
    | a <= 800.0 = print' a 0.12
    | a <= 1200.0 = print' a 0.1 
    | a <= 2000.0 = print' a 0.07
    | otherwise = print' a 0.04

main = interact
       $ function
       . map read
       . words
