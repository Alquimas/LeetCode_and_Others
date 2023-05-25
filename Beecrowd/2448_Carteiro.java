import java.io.IOException;
import java.util.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> myMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.valueOf(sc.next());
        int M = Integer.valueOf(sc.next());
        sc.nextLine();
        
        if(N == 1)
        {
            System.out.println("0");
            return;
        }
        int first = Integer.valueOf(sc.next());
        myMap.put(first, 0);
        for(int i = 1; i < N; i++)
        {
            myMap.put(Integer.valueOf(sc.next()), i);
        }
        sc.nextLine();
        int sum = 0;
        int ant = first;
        for(int i = 0; i < M; i++)
        {
            int atual = Integer.valueOf(sc.next());
            sum += Math.abs(myMap.get(atual) - myMap.get(ant));
            ant = atual;
        }
        System.out.println(sum);
    }
}
