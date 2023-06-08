class Solution {
    public int countNegatives(int[][] grid) {
        int atualEnd = grid[0].length;
        int end = grid[0].length - 1;
        int total = 0;
        for(int i = 0; i < grid.length; i++)
        {
            end = (BinarySearch(grid[i], 0, end));
            //abaixo de (i, end + 1), inclusive
            //tudo é negativo
            //há (grid.length - i) * (atualEnd - end - 1) 
            total += (grid.length - i) * (atualEnd - end - 1);
            atualEnd = end + 1;
            if(end == -1) return total;
        }
        return total;
    }
    public static int BinarySearch(int[] nums, int start, int end)
    {   
		//retorna a ultima ocasiao de um n° positivo
		//-1 se nenhum for ou nums.length tidis forem
        int max = end;
        int min = start; 
        while(min <= max)
        {
            int mid = (max + min)/2;

            if(nums[mid] <= -1)
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
}
