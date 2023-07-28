class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return search(arr);
    }
    public static int search(int[] nums) {
        int max = nums.length-1, min = 0, mid;
        while(min <= max)
        {
            mid = (max + min)/2;
            if(nums[mid] < nums[mid+1])
            {
                min = mid+1;
            }
            else if(nums[mid] < nums[mid - 1])
            {
                max = mid-1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
