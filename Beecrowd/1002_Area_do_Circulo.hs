truncate' :: Double -> Int -> Double
truncate' x n = (fromIntegral (floor (x * t))) / t
    where t = 10^n

extract :: [Double] -> Double
extract (x:[]) = x

show' :: (Show a) => a -> String
show' a = "A=" ++ show a ++ "\n"

main = interact $ show' . (`truncate'` 4) . (pi *) . (^2) . extract . map read . words 
