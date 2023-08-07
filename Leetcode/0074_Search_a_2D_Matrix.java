class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target);
    }
    static boolean search(int[][] nums, int target) {
        int max = (nums.length * nums[0].length)-1, min = 0, mid;
        while(min <= max)
        {
           mid = (max + min)/2;
           if(nums[mid / (nums[0].length)][mid % (nums[0].length)] == target)
           {
               return true;
           }
           else if(nums[mid / (nums[0].length)][mid % (nums[0].length)] < target)
           {
               min = mid+1;
           }
           else
           {
               max = mid-1;
           }
        }
        return false;
    }
}
