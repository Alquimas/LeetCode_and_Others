import Data.Char

parsing :: Int -> [String] -> String
parsing _ ("0":_) = []
parsing x (_:y:xs) = "Teste " ++ show x 
                     ++ "\n"  ++ (show $ solve y True 0 0) 
                     ++ "\n\n" ++ parsing (x + 1) xs  

solve :: String -> Bool -> Int -> Int -> Int
solve [] a y z
    | a = y + z
    | otherwise = y - z
solve (x:xs) a y z
    | isDigit x = solve xs a y (10*z + (read [x]))
    | otherwise = case x of
                      '+' -> if a 
                             then solve xs True (y + z) 0 
                             else solve xs True (y - z) 0
                      '-' -> if a 
                             then solve xs False (y + z) 0 
                             else solve xs False (y - z) 0

main = interact
       $ parsing 1
       . lines
