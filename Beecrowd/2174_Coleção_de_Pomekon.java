import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException 
    {
        int POK = 151; 
        Map<String, Boolean> myMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        
        for(int i = 0; i < N; i++)
        {
            String pok = sc.nextLine();
            if(myMap.getOrDefault(pok, true))
            {
                POK--;
                myMap.put(pok, false);
            }
        }
        
        System.out.println("Falta(m) " + POK + " pomekon(s).");
    }
}
