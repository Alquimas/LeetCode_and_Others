class Solution {
    public int[][] generateMatrix(int n) {
        int[][] myMatrix = new int[n][n];
        fillMatrix(myMatrix, 0, n-1, 1);
        return myMatrix;
    }
    private static void fillMatrix(int[][] myMatrix, int start, int end, int n)
    {
        if(start > end) return;
        for(int i = start; i <= end; i++)
        {
            myMatrix[start][i] = n;
            n++;
        }
        for(int i = start+1; i <= end; i++)
        {
            myMatrix[i][end] = n;
            n++;
        }
        for(int i = end-1; i >= start; i--)
        {
            myMatrix[end][i] = n;
            n++;
        }
        for(int i = end-1; i > start; i--)
        {
            myMatrix[i][start] = n;
            n++;
        }
        fillMatrix(myMatrix, start+1, end-1, n++);
    }
}
