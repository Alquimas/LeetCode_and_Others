class Solution {
    public int search(int[] nums, int target) {
        return Busca(nums, 0, nums.length-1, target);
    }
    //pega o elemento central
    //[a, b], [b, c]
    //se a < b, então [a, b] tá ordenado 
    //se b < c, então [b, c] tá ordenado
    //se d tá dentro de um desses, então faz busca binária ai
    //se não, ele tá no ramo não ordenado
    //repete o processo pro ramo não ordenado
    public static int Busca(int[] nums, int start, int end, int target)
    {
        int min = start;
        int max = end;

        while (min <= max) 
        {
            int mid = (min + max)/2;

            if(nums[mid] >= nums[min])
            {
                if(target <= nums[mid] && target >= nums[min])
                    return BinarySearch(nums, min, mid, target);
                min = mid + 1;
            }
            else
            {
                if(target <= nums[max] && target >= nums[mid])
                    return BinarySearch(nums, mid, max, target);
                max = mid - 1;
            }
        }
        return -1;
    }
    public static int BinarySearch(int[] nums, int start, int end, int target)
    {
        int min = start;
        int max = end;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] > target)
            {
                max = mid - 1;
            }
            else if(nums[mid] < target)
            {
                min = mid + 1;
            }
            else return mid;
        }

        return -1;
    }
}
