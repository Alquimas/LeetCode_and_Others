import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

--FORMULAS
trig :: Double -> Double -> String
trig a c = "TRIANGULO: " ++ roundToStr 3 (a * c * 0.5) ++ "\n"

circ :: Double -> String
circ c = "CIRCULO: " ++ roundToStr 3 (c * c * 3.14159) ++ "\n"

trap :: Double -> Double -> Double -> String
trap a b c = "TRAPEZIO: " ++ roundToStr 3 ((a + b) * c * 0.5) ++ "\n"

quad :: Double -> String
quad b = "QUADRADO: " ++ roundToStr 3 (b * b) ++ "\n"

ret :: Double -> Double -> String
ret a b = "RETANGULO: " ++ roundToStr 3 (a * b) ++ "\n"

show' :: [Double] -> String
show' (a:b:c:_) = trig a c ++ circ c ++ trap a b c ++ quad b ++ ret a b

main = interact $ show' . map read . words
