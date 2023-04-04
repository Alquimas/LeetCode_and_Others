class Solution 
{
    public int partitionString(String s) 
    {
        char[] string = s.toCharArray();
        int k=1;
        int l=0;
        for(int i = 0; i<s.length(); i++)
        {
            for(int j = l; j<i; j++)
            {
                if(string[j] == string[i])
                {
                    k++;
                    l=i;
                }
            }
        }
        return k;
    }
}
