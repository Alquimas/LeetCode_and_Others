class Solution {
    public String removeStars(String s) {
        char[] str = new char[s.length()];
        int j=0;

        for(char c : s.toCharArray())
        {
            if(c == '*')
            {
                //str[j] = ' ';
                j--;
            }
            else
            {
                str[j] = c;
                j++;
            }
        }

        String x = null;
        x = x.valueOf(str);

        return x.substring(0, j);
    }
}
