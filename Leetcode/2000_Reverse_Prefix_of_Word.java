class Solution {
    public String reversePrefix(String word, char ch) {
        int first = word.indexOf(ch);
        if(first == -1) return word;

        return reverseString(word, first).concat(word.substring(first+1, word.length()));
    }

    static public String reverseString(String word, int k)
    {
        StringBuilder myStr = new StringBuilder(word.substring(0, k+1));
        return myStr.reverse().toString();
    }
}
