import Control.Arrow

main = interact
       $ words 
       >>> (\(x:xs) 
            -> parsing (read x) [] xs)
            
parsing :: Int -> String -> [String] -> String
parsing 0 acc _ = acc
parsing a acc (x:y:xs)
    | go x y = parsing (a - 1) (acc ++ "encaixa\n") xs
    | otherwise = parsing (a - 1) (acc ++ "nao encaixa\n") xs
    
go :: String -> String -> Bool
go [] _ = False
go x@(z:zs) y
    | length x < length y = False
    | length x == length y = x == y
    | otherwise = go zs y
