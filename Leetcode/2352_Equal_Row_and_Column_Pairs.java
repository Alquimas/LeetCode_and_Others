class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> lineMap = new HashMap();
        int n = grid.length;
        //Map<int[]> columnMap = new HashMap();
        for(int i = 0; i < n; i++)
        {
            String temporary = Arrays.toString(grid[i]);
            lineMap.put(temporary, 1 + lineMap.getOrDefault(temporary, 0));
        }
        int[] hold = new int[n];
        int counter = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                hold[j] = grid[j][i];
            }
            String temporary = Arrays.toString(hold);
            if(lineMap.containsKey(temporary))
            {
                counter += lineMap.get(temporary);
            }
        }
        return counter;
    }
}
