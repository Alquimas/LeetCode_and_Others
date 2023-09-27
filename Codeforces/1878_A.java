import java.util.*;

public class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int k = Integer.valueOf(sc.nextLine());
        
        outerLoop:
        for(int i = 0; i < k; i++)
        {
            int a = Integer.valueOf(sc.next());
            int b = Integer.valueOf(sc.next());
            sc.nextLine();
            
            for(int j = 0; j < a; j++)
            {
                int m = Integer.valueOf(sc.next());
                if(b == m)
                {
                    System.out.println("YES");
                    sc.nextLine();
                    continue outerLoop;
                }
            }
            System.out.println("NO");
            sc.nextLine();
        }
    }
}
