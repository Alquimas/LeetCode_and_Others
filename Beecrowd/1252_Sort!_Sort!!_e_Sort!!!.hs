main = interact
       $ function
       . map read
       . words
       
function :: [Int] -> String
function (0:0:_) = "0 0\n"
function (x:y:xs) = show x ++ " " ++ show y ++ "\n" ++ showlist (quicksort y (take x xs)) ++ function (drop x xs)

showlist :: [Int] -> String
showlist [] = []
showlist (x:xs) = show x ++ "\n" ++ showlist xs

quicksort :: Int -> [Int] -> [Int]
quicksort _ [] = []
quicksort m (x:xs) = quicksort m menorEq ++ [x] ++ quicksort m maior
    where 
        menorEq = [a | a <- xs, orderingTotal x a m]
        maior = [a | a <- xs, orderingStrict a x m]
        
orderingTotal :: Int -> Int -> Int -> Bool
orderingTotal a b c 
    | a == b = True
    | mod' a c > mod' b c = True
    | mod' a c < mod' b c = False
    | (mod' a 2 == 1) && (mod' b 2 == 0) = False
    | (mod' a 2 == 0) && (mod' b 2 == 1) = True
    | (mod' a 2 == 1) && (mod' b 2 == 1) = if ((a + b) - ord a b) == a then True else False
    | (mod' a 2 == 0) && (mod' b 2 == 0) = if (ord a b) == a then True else False
    
orderingStrict :: Int -> Int -> Int -> Bool
orderingStrict a b c
    | a == b = False
    | otherwise = orderingTotal a b c

mod' :: Int -> Int -> Int
mod' a b
    | (b == 2) = mod a b
    | (a < 0) && (b > 0) = if (mod a b) == 0 then 0 else (mod a b) - b 
    | otherwise = mod a b
    
ord :: Int -> Int -> Int
ord a b
    | a > b = a
    | otherwise = b
