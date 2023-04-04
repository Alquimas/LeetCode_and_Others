class Solution 
{
    public int partitionString(String s) 
    {
        char[] max = new char[s.length()];
        char[] string = s.toCharArray();
        int k=1;
        int l=0;
        for(int i = 0; i<s.length(); i++)
        {
            if(i > 0)
            {
                for(int j = l; j<i; j++)
                {
                    if(max[j] == string[i])
                    {
                        k++;
                        l=i;
                    }
                }
            }
            max[i] = string[i];
        }
        return k;
    }
}
