//Not my code 
// Definition for a Node.
/*class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}*/
class Solution {
    public Node cloneGraph(Node node) 
    {
        if(node == null) return null; // se o no eh vazio, nao ha nada a fazer
        Node copy = new Node(node.val); // criamos um novo no, com o mesmo valor do no raiz do grafo dado
        Node[] visited = new Node[101];
        Arrays.fill(visited , null); // enche o vetor de nulls
        dfs(node , copy , visited); // faz um dfs atravessando todo o grafo
        return copy;
    }

    public void dfs(Node node , Node copy , Node[] visited)
    {
        visited[copy.val] = copy;// armazena o no atual no seu indice val, o que nos diz que esse no ja foi visitado
        
//Agora vamos visitar todos os nos vizinhos ao no atual
        for(Node n : node.neighbors)
        {
//Checa se o no ja foi visitado ou nao 
//Se nao foi visitado, o conteudo na posicao desse vetor deve conter NULL
            if(visited[n.val] == null)
            {
//cria um novo no
                Node newNode = new Node(n.val);
//adiciona esse vetor como vizinho do no copy
                copy.neighbors.add(newNode);
//chama a funcao novamente e realiza esse mesmo processo para o no newNode
                dfs(n , newNode , visited);
            }
            else
            {
//Se o no ja foi visitado, pegamos sua posicao no vetor de visitados e adicionamos ele como vizinho ao vetor copy
//Esse e o motivo para usar um vetor de Nodes e nao um boolean
                copy.neighbors.add(visited[n.val]);
            }
        }
    }
}
