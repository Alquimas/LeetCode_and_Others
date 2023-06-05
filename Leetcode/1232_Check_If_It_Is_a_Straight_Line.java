class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int A = coordinates[0][1] - coordinates[1][1];
        int B = coordinates[1][0] - coordinates[0][0];
        int C = coordinates[0][0]*coordinates[1][1] - coordinates[0][1]*coordinates[1][0];

        for(int i = 2; i < coordinates.length; i++)
        {
            if(A*coordinates[i][0] + B*coordinates[i][1] + C != 0)
            {
                return false;
            }
        }
        return true;
    }
}
//a b 1
//c d 1 == 0
//x y 1

//ad + bx + cy - dx - bc - ay = 0
//(b - d)x + (c - a)y + (ad - bc) = 0
