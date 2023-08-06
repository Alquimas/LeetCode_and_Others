parser :: [String] -> String
parser (a:xs) = function (read a) xs

function :: Int -> [String] -> String
function 0 _ = []
function _ [] = []
function a (x:xs) = show (test 0 0 $ filter myFilter x) ++ "\n" ++ function (a-1) xs
    
myFilter :: Char -> Bool
myFilter x
    | x == '<' = True
    | x == '>' = True
    | otherwise = False

test :: Int -> Int -> String -> Int
test _ b [] = b
test a b (x:xs) 
    | x == '<' = test (a+1) b xs
    | x == '>' = if a > 0
                 then test (a-1) (b+1) xs
                 else test a b xs

main = interact
       $ parser
       . lines
