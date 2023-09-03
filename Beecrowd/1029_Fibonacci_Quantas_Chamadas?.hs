pars :: [Int] -> String
pars (x:xs) = function x xs

function :: Int -> [Int] -> String
function 0 _ = []
function x (y:ys) = "fib(" ++ show y ++ ") = " 
                    ++ (show . fib) y
                    ++ " calls = " ++ (show . calls) y 
                    ++ "\n" ++ function (x-1) ys
                    
fib :: Int -> Int
fib 0 = 0
fib 1 = 0
fib k = 2 + fib (k - 1) + fib (k - 2)

calls :: Int -> Int
calls 0 = 0
calls 1 = 1
calls k = calls (k - 1) + calls (k - 2)

main = interact
       $ pars
       . map read
       . words
