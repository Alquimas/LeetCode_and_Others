main = interact
       $ (++"\n")
       . (\(x:y:_) -> show (x-y))
       . map (\a -> read a :: Int)
       . words
