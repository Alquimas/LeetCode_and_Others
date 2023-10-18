import java.util.*;

public class Main
{
    static Map<Character, Integer> myMap = new HashMap<>();

    public static boolean isLetter(char c)
    {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    public static boolean isNumber(char c)
    {
        return (c >= '0' && c <= '9');
    }
	
	public static void main(String[] args) {
	    myMap.put('+', 1);
	    myMap.put('-', 1);
	    myMap.put('*', 2);
	    myMap.put('/', 2);
	    myMap.put('^', 3);
	    
		Scanner sc = new Scanner(System.in);
		
		int k = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < k; i++)
		{
		    String s = sc.nextLine();
		    
		    Stack<Character> aux = new Stack<>();
		    String resultado = "";
		    
		    for(int j = 0; j < s.length(); j++)
		    {
		        char c = s.charAt(j);
		        
		        if(isLetter(c) || isNumber(c))
		        {
		            resultado += c;
		            continue;
		        }
		        if(c == '(')
		        {
		            aux.push(c);
		            continue;
		        }
		        if(c == ')')
		        {
		            while(!aux.isEmpty() && aux.peek() != '(')
		            {
		                resultado += aux.pop();
		            }
		            if(!aux.isEmpty()) aux.pop();
		            continue;
		        }
		        
		        while(!(aux.isEmpty() || aux.peek() == '(' || (myMap.get(c) > myMap.get(aux.peek()))))
		        {
		            resultado += aux.pop();
		        }
		        aux.push(c);
		    }
		    while(!aux.isEmpty())
		    {
		        resultado += aux.pop();
		    }
		    System.out.println(resultado);
		}
	}
}
