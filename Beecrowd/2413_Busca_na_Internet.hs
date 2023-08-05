main = interact
       $ (++"\n")
       . show
       . (\(x:_) -> x*4)
       . map read
       . words
