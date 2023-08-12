function :: Int -> [Int] -> String
function _ [] = []
function a (x:y:xs) = "Case " ++ show a ++ ": " ++ show ((outp x y) + 1) ++ "\n" ++ function (a+1) xs

outp :: Int -> Int -> Int
outp 1 _ = 0
outp a k = mod (k + outp (a - 1) k) a  

main = interact
       $ function 1
       . map read
       . tail
       . words
