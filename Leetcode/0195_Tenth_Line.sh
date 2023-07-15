# Read from the file file.txt and output the tenth line to stdout.
tail file.txt -n+10 | head -n 1

# | passa o output de um comando como argumento para o consecutivo
# cat mostra o arquivo, nesse caso passa como argumento pra tail
# tail -n+10 mostra todos as linhas A PARTIR da décima
# head -n 1 pega a primeira dessas 
# se você usa head -n 10, você acaba printando a 9° linha
