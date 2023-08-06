function :: [String] -> String
function [] = []
function (x:xs) = balance x ++ function xs

balance :: String -> String
balance x
    | test 0 $ filter (myFilter) x = "correct\n"
    | otherwise = "incorrect\n"
    
myFilter :: Char -> Bool
myFilter x
    | x == '(' = True
    | x == ')' = True
    | otherwise = False

test :: Int -> String -> Bool
test a _
    | a < 0 = False
test a []
    | a == 0 = True
    | otherwise = False
test a (x:xs) 
    | x == '(' = test (a+1) xs
    | x == ')' = test (a-1) xs

main = interact
       $ function
       . words
