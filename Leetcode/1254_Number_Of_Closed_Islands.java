import java.util.Stack;
class Solution 
{
    //vetores direcao
    //para adicionar numeros validos ao stack
    static int dPar[][] = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };

    public int closedIsland(int[][] grid) 
    {
        int contador = 0;

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

    //Define uma classe para par ordenado
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

    //checa se um par adicionado ao stack eh uma celula valida
    static Boolean Ehvalido(int grid[][], int row, int col, int ROW, int COL)
    {
        // Se a celula ta fora da matriz ou marcada como visita retorna falso
        if (row < 0 || col < 0 || row >= ROW || col >= COL || grid[row][col] == 1)
            return false;
 
 
        // Caso contrario retorna true  
        return true;
    }

    static int DFS(int row, int col, int grid[][], int ROW, int COL)
    {
        int borda=0;

        //Cria um stack de pares ordenados
        Stack<pair> st = new Stack<pair>();
        st.push(new pair(row, col));

        while (!st.empty())
        {
            // Popa o elemento no topo do stack
            // Porem salva suas infos para usar
            pair curr = st.pop();
 
            row = curr.first;
            col = curr.second;
 
            // Checa se as coordenadas do elemento popado
            // Sao de uma celula valida ou nao
            if (!Ehvalido(grid, row, col, ROW, COL))
                continue;

            if(row == 0 || col == 0 || row == ROW-1 || col == COL-1)
                borda++;

            // Marca a celula popada como visitada
            grid[row][col] = 1;

            // Adiciona os pares ordenados vizinhos ao stack
            for(int i = 0; i < 4; i++)
            {
                st.push(new pair(row + dPar[i][0], col + dPar[i][1]));
            }
        }
        return borda;
    }
}
