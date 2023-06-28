class Solution {
    public int minimumRecolors(String blocks, int k) 
    {
        int maximum = 0;
        for(int i = 0; i < k; i++)
        {
            if(blocks.charAt(i) == 'B')
            {
                maximum++;
            }
        }
        int newMaximum = maximum;
        for(int i = k; i < blocks.length(); i++)
        {
            if(blocks.charAt(i - k) == 'B')
            {
                maximum--;
            }
            if(blocks.charAt(i) == 'B')
            {
                maximum++;
            }
            newMaximum = Math.max(newMaximum, maximum);
            if(newMaximum == k)
            {
                return 0;
            }
        }
        return k - newMaximum;
    }
}
