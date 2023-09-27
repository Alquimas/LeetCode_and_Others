import java.util.*;

public class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] alvo = new String[10];
        
        int casos = Integer.valueOf(sc.nextLine());
        
        for(int i = 0; i < casos; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                alvo[j] = sc.nextLine();
            }
            
            int retorno = 0;
            
            for(int k = 0; k < 10; k++)
            {
                for(int l = 0; l < 10; l++)
                {
                    if(alvo[k].charAt(l) == 'X')
                    {
                        retorno += Math.min(k, Math.min(l, Math.min(9 - k, 9 - l))) + 1;
                    }
                }
            }
            
            System.out.println(retorno);
        }
        
        
    }
}
