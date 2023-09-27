parsing :: Int -> [String] -> String
parsing 0 _ = []
parsing a (_:y:z:xs) = show (solve y' 0 z) ++ "\n" ++ parsing (a-1) xs
    where
        y' = read y
        
solve :: Int -> Int -> String -> Int
solve _ a [] = a
solve x a (y:ys)
    | y == 'B' = solve x (a+1) (drop (x-1) ys)
    | otherwise = solve x a ys
    

main = interact
       $ (\(x:xs) -> 
          parsing (read x) xs)
       . words
