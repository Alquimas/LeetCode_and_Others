simp :: (Int, Int) -> (Int, Int)
simp (a, b) = ((div a (mdc a b)), (div b (mdc a b))) 

mdc :: Integral a => a -> a -> a
mdc a b | mod a b == 0 = b
        | mod b a == 0 = a
        | a > b = mdc b (mod a b)
        | a < b = mdc a (mod b a)
        
sgn :: Int -> Int
sgn a
    | a > 0 = 1
    | a < 0 = -1
    | otherwise = 0

read' :: String -> Int
read' a = read a

function :: [String] -> String
function [] = [] 
function (x1:_:x3:x4:x5:_:x7:xs)
    | x4 == "+" = show numsum ++ "/" ++ show den ++ " = "  ++ show (fst $ simp (numsum, den)) ++ "/" ++ show (snd $ simp (numsum, den)) ++ "\n" ++ function xs
    | x4 == "-" = show numsub ++ "/" ++ show den ++ " = "  ++ show (sgn' * (fst ( simp (sgn'*numsub, den)))) ++ "/" ++ show (snd $ simp (sgn'*numsub, den)) ++ "\n" ++ function xs
    | x4 == "*" = show nummut ++ "/" ++ show den ++ " = "  ++ show (fst $ simp (nummut, den)) ++ "/" ++ show (snd $ simp (nummut, den)) ++ "\n" ++ function xs
    | x4 == "/" = show numdiv ++ "/" ++ show dendiv ++ " = "  ++ show (fst $ simp (numdiv, dendiv)) ++ "/" ++ show (snd $ simp (numdiv, dendiv)) ++ "\n" ++ function xs
        where
            a1 = read' x1
            a2 = read' x3
            a3 = read' x5
            a4 = read' x7
            numsum = a1*a4 + a2*a3
            den = a2*a4
            numsub = a1*a4 - a2*a3
            sgn' = sgn numsub
            nummut = a1*a3
            numdiv = a1*a4
            dendiv = a2*a3
            
main = interact $ function . tail . words
