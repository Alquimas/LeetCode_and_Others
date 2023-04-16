class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int[] retorno = {0, 0};
        for(int j = 0; j<nums.length; j++)
        {
            for(int i = j+1; i<nums.length; i++)
            {
                if(nums[i] + nums[j] == target)
                {
                    retorno[0] = j;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        return retorno;
    }  
}
