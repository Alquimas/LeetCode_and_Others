import java.io.IOException;
import java.util.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.valueOf(sc.nextLine());
        
        for(int i = 0; i < n; i++)
        {
            String palavra1 = sc.nextLine();
            
            int resultado = 0;
            for(int j = 0; j < palavra1.length()/2; j++)
            {
                resultado += (palavra1.charAt(palavra1.length()/2 + j + 1) - palavra1.charAt(j) + 26)%26;
            }
            System.out.println(resultado);
        }
    }
}
