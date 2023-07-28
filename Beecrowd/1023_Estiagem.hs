--TODO: Finish the code

import Text.Printf

type Pair = (Int, Int)

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

tratamento :: Int -> [Int] -> String
tratamento a xs = printPairList (myList) ++ "Consumo Medio: " ++ roundToStr 2 (consumoMedioCidade myList) ++ " m3.\n\n"
    where 
        myList = sortList (toPairList (take (2*a) xs))

toPairList :: [Int] -> [Pair]
toPairList [] = []
toPairList (x:y:xs) = (x, y) : toPairList xs

printPairList :: [Pair] -> String
printPairList [] = []
printPairList ((a,b):[]) = show a ++ "-" ++ show (div b a) ++ "\n" 
printPairList ((a,b):xs) = show a ++ "-" ++ show (div b a) ++ " " 

sortList :: [Pair] -> [Pair] 
sortList [] = []
sortList (x:xs) = sortList menorEq ++ [x] ++ sortList maior
    where 
        menorEq = [a | a <- xs, consumoMedioCasa a <= consumoMedioCasa x]
        maior = [a | a <- xs, consumoMedioCasa a > consumoMedioCasa x]
        
consumoMedioCasa :: Pair -> Int
consumoMedioCasa (a,b) = div b a

consumoMedioCidade :: [Pair] -> Double
consumoMedioCidade x = (fromIntegral $ fst (foldl (sumFirst) (0,0) x)) / (fromIntegral $ snd (foldl (sumSecond) (0,0) x))

sumFirst :: Pair -> Pair -> Pair
sumFirst (a, _) (b, _) = (a + b, 0)

sumSecond :: Pair -> Pair -> Pair
sumSecond (_, a) (_, b) = (0, a + b)

function :: Int -> [Int] -> String
function _ [] = []
function a (x:xs) = "Cidade# " ++ show a ++ ":\n" ++ (tratamento x xs) ++ function (a+1) (drop (2*x) xs)
    
main = interact $ function 1 . map read . words
