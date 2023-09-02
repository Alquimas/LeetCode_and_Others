function :: [String] -> [Int]
function (_:a1:a2:_:a3:_:a4:_:a5:a6:_:a7:_:a8:_) = 
         calc (a1' * 86400 + a2' * 3600 + a3' * 60 + a4')
              (a5' * 86400 + a6' * 3600 + a7' * 60 + a8')
    where
        a1' = read a1
        a2' = read a2
        a3' = read a3
        a4' = read a4
        a5' = read a5
        a6' = read a6
        a7' = read a7
        a8' = read a8

calc :: Int -> Int -> [Int]
calc a b = (x:y:z:w:[])
    where 
        x = div (b - a) 86400
        y = div (mod (b - a) 86400) 3600
        z = div (mod (mod (b - a) 86400) 3600) 60
        w = mod (mod (mod (b - a) 86400) 3600) 60
        
showL :: [Int] -> String
showL (x:y:z:w:_) = x' ++ " dia(s)\n" ++ y'
                    ++ " hora(s)\n" ++ z'
                    ++ " minuto(s)\n" ++ w'
                    ++ " segundo(s)\n"
      where 
            x' = show x
            y' = show y 
            z' = show z
            w' = show w

main = interact
       $ showL
       . function
       . words
