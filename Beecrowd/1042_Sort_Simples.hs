import Data.List

show' :: [Int] -> String
show' (a:b:c:_) = show a ++ "\n" ++ show b ++ "\n" ++ show c ++ "\n"

function :: [Int] -> String
function a = (show' . sort) a ++ "\n" ++ show' a

main = interact $ function . map read . words
