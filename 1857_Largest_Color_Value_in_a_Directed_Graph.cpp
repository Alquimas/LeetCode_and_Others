//Not my code
struct Node {
    char val;
    std::vector<Node*> next;
    Node() {}
};

class Solution {
private:
    bool tem_ciclo(Node* n, std::set<Node*>& visitados, std::set<Node*>& sem_ciclo)
    {
        if(sem_ciclo.count(n)) return false;
        if(visitados.count(n)) return true;
        visitados.insert(n);

        for(Node* no : n->next)
            if(tem_ciclo(no, visitados, sem_ciclo))
                return true;
        sem_ciclo.insert(n);
        visitados.erase(n);
        return false;
    }

    std::map<char, int> dfs(Node* n, std::map<Node*, std::map<char, int>>& dp)
    {
        if(dp.count(n)) return dp[n];

        dp[n][n->val] = 0;
        for(Node* no : n->next)
            for(std::pair<char, int> p : dfs(no, dp))
                dp[n][p.first] = std::max(dp[n][p.first], p.second);

        ++dp[n][n->val];
        return dp[n];
    }

public:
    int largestPathValue(string colors, vector<vector<int>>& edges)
    {
        std::vector<Node*> aux(colors.size());
        for(int i = 0; i < aux.size(); ++i)
            aux[i] = new Node(),
            aux[i]->val = colors[i];

        std::map<Node*, std::map<char, int>> dp;
        std::set<Node*> set, sem_ciclo;

        for(std::vector<int> n : edges)
            aux[n[0]]->next.push_back(aux[n[1]]);

        for(Node* n : aux)
            if(tem_ciclo(n, set, sem_ciclo))
            {
                set.clear();
                return -1;
            }
        sem_ciclo.clear();
        set.clear();

        std::map<char, int> answ;

        for(Node* n : aux)
            for(std::pair<char, int> p : dfs(n, dp))
                answ[p.first] = std::max(answ[p.first], p.second);

        int resposta = 0;

        for(std::pair<char, int> p : answ)
            resposta = std::max(resposta, p.second);

        return resposta;
    }
};
