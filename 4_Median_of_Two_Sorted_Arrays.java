class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        if(nums1.length == 0 && nums2.length == 0) return 0;
        int[] nums = new int[nums1.length + nums2.length];
        fillArray(nums, nums1, nums2);
        Arrays.sort(nums);
        if(nums.length%2 == 0) return (double) (nums[nums.length/2] + nums[nums.length/2 - 1])/2;
        return (double) nums[nums.length/2];
    }
    private void fillArray(int[] nums, int[] nums1, int[] nums2)
    {
        for(int i = 0; i<nums1.length; i++)
        {
            nums[i] = nums1[i];
        }
        for(int i = 0; i<nums2.length; i++)
        {
            nums[nums.length-1-i] = nums2[i];
        }
    }
}
