class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        
        std::vector<std::string> v(numRows);
        int sentido = 1;
        int contador = 0;

        for(char c : s) {
            v[contador].push_back(c);
            contador += sentido;

            if(contador == -1 || contador == numRows) {
                sentido *= -1;
                contador += 2 * sentido;
            }
        }

        for(int i = 1; i < numRows; ++i) {
            v[0].insert(v[0].end(), v[i].begin(), v[i].end());
        }

        return v[0];
    }
};
