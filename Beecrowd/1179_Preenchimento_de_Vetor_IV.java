import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        Vet par = new Vet("par");
        Vet impar = new Vet("impar");
        
        for(int i = 0; i < 15; i++)
        {
            int k = Integer.parseInt(sc.nextLine());
            if(k % 2 == 0) par.insert(k);
            else impar.insert(k);
        }
        
        impar.print();
        par.print();
    }
}
class Vet
{
    private int[] vec = new int[5];
    private int size = 0;
    private String s;
    
    public Vet(String s)
    {
        this.s = s;
    }
    public void insert(int i)
    {
        if(size < 5)
        {
            vec[size] = i;
            size++;
        }
        else
        {
            this.print();
            vec[0] = i;
            size = 1;
        }
    }
    public void print()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.println(s + "[" + i + "] = " + vec[i]);
        }
    }
}
