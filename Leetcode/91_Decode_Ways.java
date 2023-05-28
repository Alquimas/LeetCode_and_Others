class Solution {
    public int numDecodings(String s) 
    {
        int dp1 = 1, dp2 = 0, n = s.length();
        for(int i = n - 1; i >= 0; i--) 
        {
            int dp = s.charAt(i) == '0' ? 0 : dp1; //se o caracter atual é 0
            //o total é 0. Caso contrário, é possível iniciar uma separação usando 
            //o caracter em i
            if(i < n - 1 && (s.charAt(i) == '1' || 
            s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                //e se os 2 primeiros caracteres tambem sao um número válido
                //adicionamos esse número ao total
                dp +=  dp2;
            
            //ideia de uma sequencia de fibonnaci
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
