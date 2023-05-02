class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        int i = 0;
        StringBuilder myString = new StringBuilder();
        while(true)
        {
            if(strs[0].length() == i) return myString.toString();
            char c = strs[0].charAt(i);
            for(String s: strs)
            {
                if(i == s.length() || c != s.charAt(i)) return myString.toString();
            }
            myString.append(c);
            i++;
        }
    }
}
