fatsum :: Integer -> Integer -> Integer
fatsum a b = fat a + fat b

fat :: Integer -> Integer
fat 0 = 1
fat n = n * fat (n - 1)

prints :: [Integer] -> String
prints [] = []
prints (x:y:xs) = show (fatsum x y) ++ "\n" ++ prints xs

main = interact $ prints . map read . words
