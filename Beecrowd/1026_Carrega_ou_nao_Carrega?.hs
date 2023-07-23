import Data.Bits
import Data.Word

bitxor :: [Word] -> [Word]
bitxor [] = []
bitxor (x:y:xs) = (xor x y) : bitxor xs

show' :: [Word] -> String
show' [] = []
show' (x:xs) = show x ++ "\n" ++ show' xs

main = interact $ show' . bitxor . map read . words
