import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.valueOf(sc.nextLine());
        
        for(int i = 0; i < N; i++)
        {
            char[] _string = sc.nextLine().toCharArray(); 
            char save;
            for(int j = 0; j < _string.length; j++)
            {
                if((_string[j] >= 'a' && _string[j] <= 'z') || (_string[j] >= 'A' && _string[j] <= 'Z'))
                {
                    _string[j] += 3;
                }
            }
            for(int j = 0; j < _string.length/2; j++)
            {
                save = _string[j];
                _string[j] = _string[_string.length - 1 - j];
                _string[_string.length - 1 - j] = save;
                
                _string[_string.length - 1 - j] -= 1;
            }
            if(_string.length % 2 == 1)
            {
                _string[_string.length/2] -= 1;
            }
            
            System.out.println(new String(_string));
        }
    }
}
