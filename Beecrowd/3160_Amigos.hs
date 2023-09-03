import Data.List

function :: [String] -> String
function (a:b:c:_)
    | c == "nao" = a ++ " " ++ b 
    | otherwise = con (words a) (words b) c
    
con :: [String] -> [String] -> String -> String
con a b c
    | x == [] = (unwords b) ++ " " ++ y
    | y == [] = x ++ " " ++ (unwords b) 
    | otherwise = x ++ " " ++ (unwords b) ++ " " ++ y
    where 
        x = (unwords (takeWhile (/= c) a)) 
        y = (unwords (dropWhile (/= c) a))
    
main = interact
       $ (++"\n")
       . function
       . lines
