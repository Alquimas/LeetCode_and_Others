import java.io.IOException;
import java.util.*;
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        char[] first = sc.next().toCharArray();
        char operator = sc.next().charAt(0);
        char[] second = sc.next().toCharArray();
        
        for(int i = 0; i < first.length; i++)
        {
            if(first[i] == '7')
                first[i] = '0';
        }
        for(int i = 0; i < second.length; i++)
        {
            if(second[i] == '7')
                second[i] = '0';
        }
        
        int result;
        
        if(operator == '+')
            result = Integer.valueOf(new String(first)) + Integer.valueOf(new String(second));
        else
            result = Integer.valueOf(new String(first)) * Integer.valueOf(new String(second));
            
        char[] cResult = Integer.toString(result).toCharArray();
        
        for(int i = 0; i < cResult.length; i++)
        {
            if(cResult[i] == '7')
                cResult[i] = '0';
        }
        System.out.println(Integer.valueOf(new String(cResult)));
    }
}
