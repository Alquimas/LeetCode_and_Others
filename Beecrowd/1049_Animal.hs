animal :: [String] -> String
animal (a:xs)
    | a == "vertebrado" = vertebrado xs
    | otherwise = invertebrado xs

vertebrado :: [String] -> String
vertebrado (b:c:_)
    | b == "ave" = ave c 
    | otherwise = mamifero c 
    
invertebrado :: [String] -> String
invertebrado (b:c:_)
    | b == "inseto" = inseto c
    | otherwise = anelideo c
    
ave :: String -> String
ave c 
    | c == "carnivoro" = "aguia\n"
    | otherwise = "pomba\n"
    
mamifero :: String -> String
mamifero c 
    | c == "onivoro" = "homem\n"
    | otherwise = "vaca\n"
    
inseto :: String -> String 
inseto c 
    | c == "hematofago" = "pulga\n"
    | otherwise = "lagarta\n"
    
anelideo :: String -> String
anelideo c 
    | c == "hematofago" = "sanguessuga\n"
    | otherwise = "minhoca\n"

main = interact
       $ animal
       . words
