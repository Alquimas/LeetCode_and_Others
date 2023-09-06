import java.util.*;

public class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < T; i++)
        {
            int N = Integer.valueOf(sc.nextLine());
            int Y = Integer.valueOf(sc.next());
            double P = Double.valueOf(sc.nextLine());
            
            int A = Integer.valueOf(sc.nextLine(), 2);
            int B = Integer.valueOf(sc.nextLine(), 2);
            int C = Integer.valueOf(sc.nextLine(), 2);
            
            double x = 1;
            double y = 1;
            
            for(int j = 0; j < N; j++)
            {
                if(j < (N - Y))
                {
                    x = x*((1 - P) * (1 - (((A ^ C) >> j) & 1)) + P * (((A ^ C) >> j) & 1));
                    y = y*((1 - P) * (1 - (((B ^ C) >> j) & 1)) + P * (((B ^ C) >> j) & 1));
                }
                else
                {
                    x = x*((1 - P) * (1 - (((B ^ C) >> j) & 1)) + P * (((B ^ C) >> j) & 1));
                    y = y*((1 - P) * (1 - (((A ^ C) >> j) & 1)) + P * (((A ^ C) >> j) & 1));
                }
            }
            
            System.out.printf("%.7f\n", x + (1 - x)*y);
        }
    }
}
