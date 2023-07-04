class Solution {
    public int[] singleNumber(int[] nums) 
    {
        int[] ans = new int[2];
        int answer = 0;

        for(int i = 0; i < nums.length; i++)
            answer ^= nums[i];

        for(int i = 0; i < 32; i++)
        {
            if((answer >> i & 1) == 1)
            {
                for(int j = 0; j < nums.length; j++)
                {
                    if((nums[j] >> i & 1) == 1)
                    {
                        ans[0] ^= nums[j];
                    }
                    else
                    {
                        ans[1] ^= nums[j];
                    }
                }
                break;
            }
        }
        
        return ans;
    }
