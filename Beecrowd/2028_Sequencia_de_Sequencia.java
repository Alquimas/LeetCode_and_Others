import java.util.*;

public class Main
{
    static String dp[] = new String[201];
    
    static int dp2[] = new int[201];
    
    public static void main (String[] args)
    {
    	dp[0] = "0";
    	dp2[0] = 1;
	    int i = 1;
	    
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext())
        {
            int k = Integer.parseInt(sc.nextLine());
	        String s = sequence(k);
	        int l = leng(k);
	        if(k == 0)
	            System.out.println("Caso " + i + ": " + l + " numero");
	        else
	            System.out.println("Caso " + i + ": " + l + " numeros");
            System.out.println(s + "\n");
            i++;
        }
    }
    
    private static String sequence(int a)
    {
        if(!(dp[a] == null))
        {
            return dp[a];
        }
        
        return (sequence(a - 1) + " " + repeat(a));
    }
    
    private static String repeat(int a)
    {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < a - 1; i++)
        {
            str.append(a);
            str.append(' ');
        }
        str.append(a);
        
        return str.toString();
    }
    
    private static int leng(int a)
    {
        if(dp2[a] != 0)
        {
            return dp2[a];
        }
        
        dp2[a] = a + leng(a - 1);
        
        return dp2[a];
    }
}
