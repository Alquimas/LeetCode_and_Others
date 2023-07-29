import Text.Printf

roundToStr :: (PrintfArg a, Floating a) => Int -> a -> String
roundToStr = printf "%0.*f"

function :: [Double] -> String
function (a:b:c:d:_) 
    | media >= 7 = "Media: " ++ roundToStr 1 media ++ "\nAluno aprovado.\n"
    | media < 5 = "Media: " ++ roundToStr 1 media ++ "\nAluno reprovado.\n"
    where 
        media = (2*a + 3*b + 4*c + d)/10
function (a:b:c:d:e:_)
    | (media >= 5 && media < 7) && final >= 5 = "Media: " ++ roundToStr 1 media ++ "\nAluno em exame.\nNota do exame: " ++ roundToStr 1 e ++ "\nAluno aprovado.\nMedia final: " ++ roundToStr 1 final ++ "\n"
    | (media >= 5 && media < 7) && final < 5 = "Media: " ++ roundToStr 1 media ++ "\nAluno em exame.\nNota do exame: " ++ roundToStr 1 e ++ "\nAluno reprovado.\nMedia final: " ++ roundToStr 1 final ++ "\n"
    where 
        media = (2*a + 3*b + 4*c + d)/10
        final = (media + e)/2

main = interact $ function . map read . words
