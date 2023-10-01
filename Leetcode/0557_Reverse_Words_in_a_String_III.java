public class Solution {
    public String reverseWords(String s) {
        String[] sList = s.split("\\s+");
        //regex que colide com 1 ou mais espaços
        StringBuilder r = new StringBuilder();
        for (String word : sList) {
            StringBuilder rWord = new StringBuilder(word);
            rWord.reverse(); 
            r.append(rWord).append(" "); 
        }
        return r.toString().trim(); 
        //remove o espaço final
    }
}
