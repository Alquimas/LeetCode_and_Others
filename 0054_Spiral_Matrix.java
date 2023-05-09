class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> myList = new ArrayList<>();
        sumLoop(matrix, 0, matrix.length-1, 0, matrix[0].length-1, myList);
        return myList;

    }
    private void sumLoop(int[][] matrix, int istart, int iend, int jstart, int jend, List<Integer> myList)
    {
        if(jstart > jend || istart > iend) return;
        for(int j = jstart; j <= jend; j++)
        {
            myList.add(matrix[istart][j]);
        }

        if(istart == iend) return;
        for(int i = istart+1; i <= iend; i++)
        {
            myList.add(matrix[i][jend]);
        }

        if(jstart == jend) return;
        for(int j = jend-1; j >= jstart; j--)
        {
            myList.add(matrix[iend][j]);
        }

        for(int i = iend-1; i > istart; i--)
        {
            myList.add(matrix[i][jstart]);
        }
        
        sumLoop(matrix, istart+1, iend-1, jstart+1, jend-1, myList);
    }
}
