function :: [Int] -> [Int] -> String
function _ (0:_) = []
function a (x:xs) = (show ((outp x a) + 1)) ++ "\n" ++ function a xs

isPrime :: Int -> Bool
isPrime n
    | n <= 1 = False
    | otherwise = not $ any (\a -> mod n a == 0) [2..sqrtX]
    where 
        sqrtX = floor (sqrt (fromIntegral n))

firstNPrimes :: Int -> [Int]
firstNPrimes k = take k (filter isPrime [2..])

outp :: Int -> [Int] -> Int
outp 1 _ = 0
outp a (k:ks) = mod (k + outp (a - 1) ks) a

main = interact
       $ function (firstNPrimes 3501)
       . map read
       . words
