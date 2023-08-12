function :: Int -> String
function a
    | a == 1 = "January"
    | a == 2 = "February"
    | a == 3 = "March"
    | a == 4 = "April"
    | a == 5 = "May"
    | a == 6 = "June"
    | a == 7 = "July"
    | a == 8 = "August"
    | a == 9 = "September"
    | a == 10 = "October"
    | a == 11 = "November"
    | a == 12 = "December"

main = interact
       $ (++"\n")
       . function
       . (\(x:_) -> x)
       . map read
       . words
