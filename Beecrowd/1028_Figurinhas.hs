mdc :: Integral a => a -> a -> a
mdc a b | mod a b == 0 = b
        | mod b a == 0 = a
        | a > b = mdc b (mod a b)
        | a < b = mdc a (mod b a)

mdcList :: [Int] -> [Int]
mdcList [] = []
mdcList (x:y:zs) = mdc x y : mdcList zs

show' :: [Int] -> String
show' [] = []
show' (x:xs) = (show x) ++ "\n" ++ (show' xs)

main = interact $ show' . mdcList . map read . tail . words
