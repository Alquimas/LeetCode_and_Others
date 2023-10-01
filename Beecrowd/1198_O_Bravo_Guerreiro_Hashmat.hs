import Data.List
import Data.Sequence
import Data.Foldable (toList)

parsing :: [String] -> Seq Char
parsing [] = empty
parsing (x:y:xs) = solve (read x) (read y) >< fromList "\n"
                   >< parsing xs
                   
solve :: Integer -> Integer -> Seq Char
solve x y = fromList ( show ( abs $ x - y ) )

main = interact
       $ toList
       . parsing
       . words
