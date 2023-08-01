import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        int[] myArray = new int[n];
        long carneiros = 0;
        
        int visitados = 1;
        
        for(int i = 0; i < n; i++)
        {
            myArray[i] = Integer.parseInt(sc.next());
            carneiros += myArray[i];
        }
        
        int atual = 0;
        
        while(!(atual == -1 || atual == n))
        {
            int actual = atual;
            boolean isZero = !(myArray[atual] == 0);
            
            if(myArray[actual] % 2 == 0) atual--;
            else atual++;
            
            if(isZero)
            {
                carneiros--;
                myArray[actual]--;
            }
            
            visitados = Math.max(visitados, actual+1);
        }
        
        System.out.println(visitados + " " + carneiros);
    }
}
