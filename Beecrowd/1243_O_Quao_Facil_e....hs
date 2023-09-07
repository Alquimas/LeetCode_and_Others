import Data.Char

pars :: [String] -> String
pars [] = []
pars (x:xs) = function (words x) 
              ++ "\n" ++ pars xs
              
function :: [String] -> String
function x = go x
    where
        go x
            | z <= 3 = "250"
            | z <= 5 = "500"
            | otherwise = "1000"
        y = filter isWord' x
        z = div' (wordLength (concat y)) (length y)

div' :: Int -> Int -> Int
div' x y
    | y == 0 = 0
    | otherwise = div x y

isWord' :: String -> Bool
isWord' [] = True
isWord' [x, y]
    | isLetter x && (isLetter y || y == '.') = True
    | otherwise = False
isWord' (x:xs) = isLetter x && isWord' xs

wordLength :: String -> Int
wordLength [] = 0
wordLength ('.':xs) = wordLength xs
wordLength (_:xs) = 1 + wordLength xs

main = interact
       $ pars
       . lines
