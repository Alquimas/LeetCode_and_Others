import Data.Char

pars :: [String] -> String
pars (x:xs) = function (read x) xs

function :: Int -> [String] -> String
function 0 _ = []
function a (x:xs) = (descLeft . reverse . descRight) x
                    ++ "\n" ++ function (a-1) xs
                    
descRight :: String -> String
descRight [] = []
descRight (x:xs)
    | ord x < 123 && ord x > 96 = 
      chr ((ord x) + 3) : descRight xs
    | ord x < 91 && ord x > 64 =
      chr ((ord x) + 3) : descRight xs
    | otherwise = x : descRight xs
    
descLeft :: String -> String
descLeft xs = take (div (length xs) 2) xs 
            ++ map go (drop (div (length xs) 2) xs)
    where
        go x = chr ((ord x) - 1)

main = interact
       $ pars 
       . lines
