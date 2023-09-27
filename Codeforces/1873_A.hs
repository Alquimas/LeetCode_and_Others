function :: Int -> [String] -> String
function 0 _ = []
function a (x:xs) = test x ++ function (a-1) xs
     
test :: String -> String
test "abc" = "YES\n"
test "bac" = "YES\n"
test "acb" = "YES\n"
test "cba" = "YES\n"
test _ = "NO\n"     

main = interact
       $ (\(x:xs) -> function (read x) xs)
       . words
