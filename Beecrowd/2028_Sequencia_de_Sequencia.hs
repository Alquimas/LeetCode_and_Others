sequence' :: Int -> [Int]
sequence' 0 = [0]
sequence' a = sequence' (a-1) ++ (take a (repeat a))

showList' :: [Int] -> String
showList' [] = []
showList' (x:[]) = show x
showList' (x:xs) = (show x) ++ " " ++ showList' xs

function :: Int -> [Int] -> String
function _ [] = []
function a (0:xs) = "Caso " ++ show a ++ ": 1 numero\n0\n" ++ function (a + 1) xs
function a (x:xs) = "Caso " ++ show a ++ ": " ++ show c ++ " numeros\n" ++ showList' b ++ "\n" ++ function (a + 1) xs
    where 
        b = sequence' x
        c = length b

main = interact $ function 1 . map read . words
