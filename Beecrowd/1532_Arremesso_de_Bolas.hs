parsing :: [Int] -> String
parsing (0:0:_) = []
parsing (x:y:xs) = solve x y ++ "\n" ++ parsing xs

solve :: Int -> Int -> String
solve _ 0 = "impossivel"
solve x y
    | x `elem` (generate y 0) = "possivel"
    | otherwise = solve x (y - 1)
    
generate :: Int -> Int -> [Int]
generate 1 a = [a + 1]
generate y a = [(a + y),(a + 2 * y)..(a + y * y)] 
               ++ generate (y - 1) (a + y * y)

main = interact
       $ parsing
       . map read
       . words
