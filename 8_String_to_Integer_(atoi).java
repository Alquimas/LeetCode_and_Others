class Solution {
    int value=1;
    public int myAtoi(String s) {
        try
        {
            int i = 0;
            int sSize = s.length();

            while(i != sSize && s.charAt(i) == ' ') i++;

            if(i != sSize && (s.charAt(i) == '-' || s.charAt(i) == '+' )) 
            {
                if(s.charAt(i) == '-') value*=(-1);
                i++;
            }

            int j = i;
            while(j != sSize && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;

            if(j > i) return (value*Integer.parseInt(s.substring(i,j)));
            
            return 0;
        }
        catch(NumberFormatException nexc)
        {
            if(value==-1) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}
