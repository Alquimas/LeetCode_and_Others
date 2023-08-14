str :: [Int]
str = [2,4..100]

showl :: [Int] -> String
showl [] = []
showl (x:xs) = show x ++ "\n" ++ showl xs

main = (putStr . showl) str
