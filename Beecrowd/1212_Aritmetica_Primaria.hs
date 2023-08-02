function :: [Int] -> String
function (0:0:[]) = []
function (x:y:xs) = (carry x y False 0) ++ function xs

binary :: Bool -> Int
binary True = 1 
binary False = 0

carry :: Int -> Int -> Bool -> Int -> String
carry x y a c
    | ((x == 0) || (y == 0)) && not a = case c of 
                                             0 -> case0
                                             1 -> case1
                                             _ -> show c ++ case2
    | (((x == 0) && (y == 9)) || ((x == 9) && (y == 0))) && a = case c of
                                                                  0 -> case1
                                                                  _ -> show (c + 1) ++ case2
    | otherwise = case (k > 9) of
                       True -> carry (div x 10) (div y 10) True (c+1)
                       _ -> carry (div x 10) (div y 10) False (c)
    where 
        case0 = "No carry operation.\n"
        case1 = "1 carry operation.\n"
        case2 = " carry operations.\n"
        resx = mod x 10
        resy = mod y 10
        k = resx + resy + binary a

main = interact $ function . map read . words
