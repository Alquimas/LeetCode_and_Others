import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        String output = "";
        
        outerloop:
        while(sc.hasNext())
        {
            char[] s = sc.nextLine().toCharArray();
            
            if(s.length == 0)
            {
                output += "error\n";
                continue;
            }
            
            int t = 0;
            boolean p = false;
            
            for(int i = 0; i < s.length; i++)
            {
                int k = 0;
                if(s[i] == 'O' || s[i] == 'o') k = 0;
                else if(s[i] == 'l') k = 1;
                else if(s[i] == ',' || s[i] == ' ') continue;
                else if(s[i] < '0' || s[i] > '9')
                {
                    output += "error\n";
                    continue outerloop;
                }
                else
                { 
                    k = s[i] - '0';
                }
                
                p = true;
                
                if(t <= Integer.MAX_VALUE/10)
                {
                    if(t == Integer.MAX_VALUE/10)
                    {
                        if(k < 8)
                        {
                            t *= 10;
                            t += k;
                        }
                        else
                        {
                            output += "error\n";
                            continue outerloop;
                        }
                    }
                    else
                    {
                        t *= 10;
                        t += k; 
                    }
                }
                else
                {
                    output += "error\n";
                    continue outerloop;
                }
            }
            if(p)
                output += Integer.toString(t) + "\n";
            else
                output += "error\n";
        }
        System.out.print(output + "error\n");
    }
}
