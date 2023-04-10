import java.util.Arrays;
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        char[] chars = s.toCharArray();
        char[] save = new char[s.length()+1];
        int j = 1;
        for(int i = 0; i<s.length(); i++)
        {
            if(chars[i] == '{' || chars[i] == '[' || chars[i] == '(')
            {
                save[j] = chars[i];
                j++;
            }
            if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')')
            {
                if(chars[i] == '}')
                {
                    if(save[j-1] == '{')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(chars[i] == ']')
                {
                    if(save[j-1] == '[')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(chars[i] == ')')
                {
                    if(save[j-1] == '(')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        if(j > 1)
            return false;

        return true;
    }
}
