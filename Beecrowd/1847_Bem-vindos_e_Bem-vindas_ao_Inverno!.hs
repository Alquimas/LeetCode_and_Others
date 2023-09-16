function :: Int -> Int -> Int 
            -> String
function x y z
    | x > y && y <= z = ":)\n"
    | x < y && y >= z = ":(\n"
    | x < y && y < z
      && (z - y < y - x) = ":(\n"
    | x < y && y < z 
      && (z - y >= y - x) = ":)\n"
    | x > y && y > z
      && (y - z < x - y) = ":)\n"
    | x > y && y > z 
      && (y - z >= x - y) = ":(\n"
    | x == y && y < z = ":)\n"
    | x == y && y >= z = ":(\n"

main = interact
       $ (\(x:y:z:_) -> 
         function x y z)
       . map read
       . words
