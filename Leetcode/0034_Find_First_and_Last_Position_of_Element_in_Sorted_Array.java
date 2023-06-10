class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) return (new int[] {-1, -1});

        int a = BS1(nums, 0, nums.length-1, target);
        int b = BS2(nums, 0, nums.length-1, target);

        if(a + 1 > b - 1) return (new int[] {-1, -1});
        
        return (new int[] {a + 1, b - 1});
        
    }
    public static int BS1(int[] nums, int start, int end, int target)
    {
    //retorna a posicao anterior a primeira ocorrencia do target
        int min = start;
        int max = end;
        
        if(nums[min] >= target) return -1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] >= target)
            {
                max = mid - 1;
            }
            else
            {
                min = mid + 1;
            }
        }

        return max;
    }
    public static int BS2(int[] nums, int start, int end, int target)
    {
    //retorna a posicao seguinte a ultima ocorrencia do target
        int min = start;
        int max = end;
        
        if(nums[max] <= target) return max+1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] <= target)
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        }
        return min;
    }
}
