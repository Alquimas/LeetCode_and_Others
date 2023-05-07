class Solution 
{
    public int lengthOfLIS(int[] nums) {
        int[] A = new int[nums.length];
        int len = 1;
        
        A[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < A[0])
            {
                A[0] = nums[i];
                continue;
            }
            if(nums[i] > A[len-1])
            {
                A[len++] = nums[i];
            }
            else
            {
                A[BinarySearch(A, -1, len-1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    
    static int BinarySearch(int[] array, int min, int max, int value)
    {
        while(max > min + 1)
        {
            int mid = (max + min)/2;
            if(array[mid] >= value)
            {
                max = mid;
            }
            else
            {
                min = mid;
            }
        }
        return max; 
    }
}
