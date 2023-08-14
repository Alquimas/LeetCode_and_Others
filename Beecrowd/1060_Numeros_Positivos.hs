main = interact
       $ (++" valores positivos\n")
       . show 
       . length 
       . filter (>0) 
       . (\(a:b:c:d:e:f:_) -> [a,b,c,d,e,f])
       . map (\a -> read a :: Double)
       . words
