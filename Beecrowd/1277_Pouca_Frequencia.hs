parsing :: Int -> [String] -> String
parsing 0 _ = []
parsing a (x:xs) = (unwords . words) (solve (take x' xs)
                   (take x' (drop x' xs)))
                   ++ "\n" ++ parsing (a - 1) 
                   (drop x' (drop x' xs))
    where
        x' = read x
        
solve :: [String] -> [String] -> String
solve [] [] = []
solve (x:xs) (y:ys)
    | _b / _a < 0.75 = x ++ " " ++ solve xs ys
    | otherwise = solve xs ys
    where
        a = filter (/= 'M') y
        b = filter (== 'P') a
        _b = fromIntegral $ length b
        _a = fromIntegral $ length a
        
main = interact
       $ (\(x:xs) -> parsing (read x) xs)
       . words
