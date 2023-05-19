class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DUS myDUS = new DUS(n);
        int total=0;
        
        for(int i = 0; i<edges.length; i++)
            if(edges[i][0] == 3)
                if(myDUS.union(edges[i][1]-1, edges[i][2]-1)) total++;

        DUS myDUS2 = new DUS(myDUS);
        int subset = n-total, subset2 = n-total;
        
        for(int i = 0; i<edges.length; i++)
        {
            if(edges[i][0] == 2)
            {
                if(myDUS.union(edges[i][1]-1, edges[i][2]-1))
                { 
                    subset--;
                    total++;
                }
            }
            if(edges[i][0] == 1)
            {
                if(myDUS2.union(edges[i][1]-1, edges[i][2]-1))
                {
                    subset2--;
                    total++;
                }
            }
        }

        if(subset+subset2>2)
            return -1;
        return edges.length-total;
        
    }

    class DUS 
    {
        public int[] rank, parent;
        public int n;
 
        public DUS(int n)
        {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        public DUS(DUS a)
        {
            this.n = a.n;
            rank = new int[this.n];
            parent = new int[this.n];
            for(int i = 0; i<n; i++)
            {
                this.rank[i] = a.rank[i];
                this.parent[i] = a.parent[i];
            }
        }
 
        void makeSet()
        {
            for (int i = 0; i < n; i++) 
            {
                parent[i] = i;
            }
        }
 
        int find(int x)
        {
            if (parent[x] != x) 
            {
                parent[x] = find(parent[x]);
            }
 
            return parent[x];
        }
 
        boolean union(int x, int y)
        {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return false;

            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else
            {
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
            return true;
        }
    }
}
