import Control.Arrow

main = interact
       $ words 
       >>> (map change) 
       >>> solve 0 [] True
       
change :: String -> String
change "<br>" = "\n"
change "<hr>" = "\n--------------------------------------------------------------------------------\n"
change x = x

solve :: Int -> String -> Bool -> [String] -> String
solve _ acc t []
    | t = acc
    | otherwise = acc ++ "\n"
    
solve _ acc _ ("\n":xs) = solve 0 (acc ++ "\n") True xs

solve _ acc t ("\n--------------------------------------------------------------------------------\n":xs)
    | t = solve 0 (acc++"--------------------------------------------------------------------------------\n") True xs
    | otherwise = solve 0 (acc++"\n--------------------------------------------------------------------------------\n") True xs
    
solve a acc t (x:xs)
    | x' + a + 1 < 80 = case t of
                        True -> solve (x' + a) (acc ++ x) False xs
                        False -> solve (x' + a + 1) (acc ++ " " ++ x) False xs
    | x' + a + 1 == 80 = solve 0 (acc ++ x ++ "\n") True xs
    | x' == 80 = case t of
                 True -> solve 0 (acc ++ x ++ "\n") True xs
                 False -> solve 0 (acc ++ "\n" ++ x ++ "\n") True xs
    | otherwise = solve x' (acc ++ "\n" ++ x) False xs
    where
        x' = length x
