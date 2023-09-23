import Data.List
import Data.Sequence
import Data.Foldable (toList)

parsing :: Int -> [String] -> String
parsing a xs = toList (go a xs empty [])

go :: Int -> [String] -> Seq Char -> [Int] -> Seq Char
go 0 _      y _  = y
go a (x:xs) y zs
    | x == "MIN" = 
        if zs == [] 
        then go (a - 1) xs (y >< fromList "EMPTY\n") zs
        else go (a - 1) xs (y >< ((fromList . show . head) zs >< fromList "\n")) zs
    | x == "POP" = 
        if zs == [] 
        then go (a - 1) xs (y >< fromList "EMPTY\n") zs 
        else go (a - 1) xs y (tail zs)
    | otherwise = 
        if zs == []
        then go (a - 1) xs y (c : [])
        else go (a - 1) xs y ((min c (head zs)) : zs)
            where
                c = read ((head . tail . words) x)
            
main = interact
       $ (\(x:xs) -> 
          parsing (read x) xs)
       . lines
