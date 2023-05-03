class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<(matrix.length)/2; i++)
            for(int j = i; j<matrix.length-1-i; j++)
            {
                int auxiliar = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
                matrix[matrix.length-1-j][matrix.length-1-i] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[j][i];
                matrix[j][i] = auxiliar;
            }
    }
}
