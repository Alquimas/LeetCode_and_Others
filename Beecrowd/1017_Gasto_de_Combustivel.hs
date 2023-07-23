import Text.Printf

roundToStr :: Int -> Double -> String
roundToStr = printf "%0.*f"

main = interact $ (++"\n") . (roundToStr 3) . (/12) . (foldl1 (*)) . map read . words
