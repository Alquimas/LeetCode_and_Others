pars :: [String] -> String
pars (x:xs) = function (read x) xs

function :: Int -> [String] -> String
function 0 _ = []
function a (x:xs) = reverse ( fst y ) ++ 
                    reverse ( snd y ) ++ 
                    "\n" ++
                    function (a-1) xs
    where
        y =  splitAt (div (length x) 2) x

main = interact
       $ pars 
       . lines
