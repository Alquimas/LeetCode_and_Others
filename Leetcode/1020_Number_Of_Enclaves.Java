import java.util.Stack;
class Solution {
    static int dLinha[] = { 0, 1, 0, -1 };
    static int dColuna[] = { -1, 0, 1, 0 };

    public int numEnclaves(int[][] grid) 
    {
        if(grid.length < 2 || grid[0].length < 2)
            return 0;
        int contador = 0;  
        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][0] == 1)
            {
                DFS(i, 0, grid, grid.length, grid[0].length);
            }
            if(grid[i][grid[0].length-1] == 1)
            {
                DFS(i, grid[0].length-1, grid, grid.length, grid[0].length);
            }
        }
        for(int i = 0; i < grid[0].length; i++)
        {
            if(grid[0][i] == 1)
            {
                DFS(0, i, grid, grid.length, grid[0].length);
            }
            if(grid[grid.length-1][i] == 1)
            {
                DFS(grid.length-1, i, grid, grid.length, grid[0].length);
            }
        }
        for(int i = 1; i < grid.length-1; i++)
            for(int j = 1; j < grid[0].length-1; j++)
                if(grid[i][j] == 1)
                    contador++;
        return contador;
    }

    static class pair
    {
        public int first;
        public int second;
 
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static Boolean Ehvalido(int grid[][], int row, int col, int ROW, int COL)
    {
        // Se a celula ta fora da matrix
        if (row < 0 || col < 0 || row >= ROW || col >= COL)
            return false;
 
        // Ou ja foi visitada
        if (grid[row][col] == 0)
            return false;
 
        // Se nao, pode ser visitada 
        return true;
    }

    static void DFS(int row, int col, int grid[][], int ROW, int COL)
    {
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        while (!st.empty())
        {
        
            // Pop the top pair
            pair curr = st.pop();
 
            row = curr.first;
            col = curr.second;
 
            // Check if the current popped
            // cell is a valid cell or not
            if (!Ehvalido(grid, row, col, ROW, COL))
                continue;
            
            grid[row][col] = 0;

            for(int i = 0; i < 4; i++)
            {
                int adjx = row + dLinha[i];
                int adjy = col + dColuna[i];
                st.push(new pair(adjx, adjy));
            }
        }
    }
}
