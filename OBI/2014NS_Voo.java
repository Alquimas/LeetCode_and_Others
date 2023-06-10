import java.util.*;
public class voo
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        String d = sc.next();

        int A = 60*(Integer.valueOf(a.substring(0,2))) + (Integer.valueOf(a.substring(3,5)));
        int B = 60*(Integer.valueOf(b.substring(0,2))) + (Integer.valueOf(b.substring(3,5)));
        int C = 60*(Integer.valueOf(c.substring(0,2))) + (Integer.valueOf(c.substring(3,5)));
        int D = 60*(Integer.valueOf(d.substring(0,2))) + (Integer.valueOf(d.substring(3,5)));

        int E = ((B - A) + (D - C));
        E /= 2;
        E = (E > 0) ? E%720 : 720 + E%720; 
        int I = ((B - A) - E)/60;
        if(I > 12)
        {
            I = -24 + I;
        }
        if(I <= -12)
        {
            I = 24 + I;
        }
        System.out.println((E + " " + I));
        sc.close();
	}
}
