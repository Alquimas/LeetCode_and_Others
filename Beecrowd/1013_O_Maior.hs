maior :: (Integral a) => a -> a -> a 
maior x y = div (x + y + abs(x - y)) 2 

omaior :: (Integral a) => [a] -> a
omaior (x:y:z:_) = maior (maior x y) z

show' :: (Show a) => a -> String
show' a = show a ++ " eh o maior\n"

main = interact $ show' . omaior . map read . words
