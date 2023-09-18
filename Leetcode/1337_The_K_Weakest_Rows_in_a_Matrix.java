public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        int[][] rowStrengths = new int[mat.length][2];

        Comparator<int[]> comparator = new nComp();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);
        
        for (int i = 0; i < mat.length; ++i) 
        {
            int strength = BS1(mat[i], 0, mat[i].length-1, 0);

            minHeap.offer(new int[]{strength, i});
        }
        
        int[] result = new int[k];

        for (int i = 0; i < k; ++i) {
            result[i] = minHeap.poll()[1];
        }
        
        return result;
    }
    static int BS1(int[] nums, int start, int end, int target)
    {
    //retorna a posicao anterior a primeira ocorrencia do target
        int min = start;
        int max = end;
        
        if(nums[min] <= target) return -1;
        
        while (min <= max) 
        {
            int mid = (min + max)/2;

            if (nums[mid] <= target)
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
    class nComp implements Comparator<int[]>
    {
        @Override
        public int compare(int[] x, int[] y)
        {
            return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
        }
    }
}
