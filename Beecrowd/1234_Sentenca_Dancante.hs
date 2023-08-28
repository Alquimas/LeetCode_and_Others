import Data.Char

reader :: [String] -> [String]
reader [] = []
reader (x:xs) = function True x : reader xs

function :: Bool -> String -> String
function _ [] = []
function a (x:xs)
    | x == ' ' = x : function a xs
    | a = toUpper x : function False xs
    | otherwise = toLower x : function True xs

main = interact
       $ unlines
       . reader
       . lines
