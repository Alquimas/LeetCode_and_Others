parser :: [String] -> [String]
parser ("0":"0":[]) = []
parser (x:y:xs) = function True y (head x) : parser xs

function :: Bool -> String -> Char -> String
function _ [] _ = [] 
function True (x:xs) a
    | (x == '0') || (x == a) = function True xs a
    | otherwise = x : function False xs a
function False (x:xs) a
    | (x == a) = function False xs a
    | otherwise = x : function False xs a
    
show' :: String -> String
show' [] = "0\n"
show' a = a ++ "\n"

main = interact $ concat . map show' . parser . words
