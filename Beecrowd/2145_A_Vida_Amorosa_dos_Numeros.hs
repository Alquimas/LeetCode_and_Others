import Control.Arrow

main = interact
     $ words >>> map read >>> parsing
     
parsing :: [Int] -> String
parsing (0:0:_) = []
parsing (x:y:xs) = solve x y ++ "\n" ++ parsing xs

solve :: Int -> Int -> String
solve a b
    | (mod a b' == 0) && (mod b a' == 0) = "Friends and lovers <3"
    | a' == b' = "Almost lovers!"
    | (mod a b' == 0) = show a ++ " friendzoned " ++ show b ++ "!"
    | (mod b a' == 0) = show b ++ " friendzoned " ++ show a ++ "!"
    | otherwise = "No connection."
    where
        a' = sumDivisors a
        b' = sumDivisors b

sumDivisors :: Int -> Int
sumDivisors n = soma n 0 $ filter (\x -> (mod n x == 0)) [1..sqrtN]
    where
        sqrtN = floor (sqrt (fromIntegral n))
        
soma :: Int -> Int -> [Int] -> Int
soma n a [] = a - n
soma n a (x:xs)
    | x == (div n x) = soma n (a + x) xs
    | otherwise = soma n (a + x + (div n x)) xs
