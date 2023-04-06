import java.util.Stack;
class Solution 
{
    //vetores direcao
    //para adicionar numeros validos ao stack
    static int dLinha[] = { 0, 1, 0, -1 };
    static int dColuna[] = { -1, 0, 1, 0 };

    public int closedIsland(int[][] grid) 
    {
        int contador = 0;

        if(grid.length < 2 || grid[0].length < 2)
            return 0;
        for(int i = 1; i<grid.length-1; i++)
        {
            for(int j = 1; j<grid[0].length-1; j++)
            {
                if(grid[i][j]==0)
                {
                    if(DFS(i, j, grid, grid.length, grid[0].length) == 0)
                        contador++;
                }
            }
        }
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
        if (grid[row][col] == 1)
            return false;
 
        // Se nao, pode ser visitada 
        return true;
    }

    static int DFS(int row, int col, int grid[][], int ROW, int COL)
    {
        int borda=0;
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
            if(row==0 || col==0 || row==ROW-1 || col==COL-1)
                borda++;
            grid[row][col] = 1;
            
            for(int i = 0; i < 4; i++)
            {
                int adjx = row + dLinha[i];
                int adjy = col + dColuna[i];
                st.push(new pair(adjx, adjy));
            }
        }
        return borda;
    }
}
