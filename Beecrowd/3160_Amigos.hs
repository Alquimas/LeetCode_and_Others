import Data.List

function :: [String] -> String
function (a:b:c:_)
    | c == "nao" = a ++ " " ++ b 
    | otherwise = con (words a) b c
    
con :: [String] -> String -> String -> String
con a b c = (unwords (takeWhile (/= c) (a))) ++ " " ++ b ++ " " ++ (unwords (dropWhile (/= c) a))
    
main = interact
       $ (++"\n")
       . function
       . lines
