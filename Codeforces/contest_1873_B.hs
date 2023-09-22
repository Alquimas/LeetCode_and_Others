    import Data.List
     
    parsing :: Int -> [Int] -> String
    parsing 0 _ = []
    parsing x (y:ys) = solve (take y ys) ++ "\n"
                       ++ parsing (x-1) (drop y ys)
                       
    solve :: [Int] -> String
    solve = show . (foldr (*) 1) . add . sort
        where 
            add xs = ((head xs) + 1) : (tail xs)
     
    main = interact
           $ (\(x:xs) -> parsing x xs)
           . map read
           . words
