fat :: Int -> Int -> Int
fat acc 0 = acc
fat acc x = fat (x*acc) (x - 1)

main = interact
       $ (++"\n")
       . show
       . fat 1
       . (\(x:_) -> x)
       . map read
       . words
