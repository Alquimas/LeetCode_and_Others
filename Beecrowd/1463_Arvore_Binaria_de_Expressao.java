import java.util.*;

public class Main
{
    public static char[] toInfix(String s) {
        char[] result = new char[(s.length() + 1)/2];
        
        Map<Character, Integer> myMap = new HashMap<>();
        myMap.put('+', 1);
	    myMap.put('-', 1);
	    myMap.put('*', 2);
	    myMap.put('/', 2);
	    
	    Stack<Character> aux = new Stack<>();
	    int i = 0;
	    
	    for(int j = 0; j < s.length(); j+=2)
	    {
	        char c = s.charAt(j);
	        
	        if(isLetter(c) || isNumber(c))
	        {
	            result[i] = c;
	            i++;
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
	                result[i] = aux.pop();
	                i++;
	            }
	            if(!aux.isEmpty()) aux.pop();
	            continue;
	        }
	        
	        while(!(aux.isEmpty() || aux.peek() == '(' || (myMap.get(c) > myMap.get(aux.peek()))))
	        {
	            result[i] = aux.pop();
	            i++;
	        }
	        aux.push(c);
	    }
	    while(!aux.isEmpty())
	    {
	        result[i] = aux.pop();
	        i++;
	    }
	    return result;
    }
    
    public static boolean isLetter(char c)
    {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    public static boolean isNumber(char c)
    {
        return (c >= '0' && c <= '9');
    }
    
    static class Node
    {
        char conteudo;
        int altura;
        Node esq;
        Node dir;
        
        Node (char conteudo)
        {
            this.conteudo = conteudo;
            this.altura = 0;
            this.esq = null;
            this.dir = null;
        }
    }
    static class Btree
    {
        Node raiz;
        
        Btree(char[] t)
        {
            Stack<Node> aux = new Stack<>();
            
            for(int i = 0; i < t.length; i++) {
                if(t[i] == 0) continue;
                
                if(isLetter(t[i]) || isNumber(t[i])) {
                    aux.push(new Node(t[i]));
                }
                else {
                    Node a = new Node(t[i]);
                    if(!aux.isEmpty())
                        a.dir = aux.pop();
                    if(!aux.isEmpty())
                        a.esq = aux.pop();
                        
                    aux.push(a);
                }
            }
            raiz = aux.pop();
        }
        
        void BFS()
        {
            int level = -1;
            Queue<Node> queue = new LinkedList<>();
            queue.add(raiz);
            
            while (!queue.isEmpty()) {
                
                Node aux = queue.poll();
                
                if(aux.altura != level) {
                    level++;
                    if(level != 0) System.out.print("\n");
                    
                    System.out.print("Nivel " + level + ": ");
                }
                
                System.out.print(aux.conteudo);
                
                if (aux.esq != null) {
                    aux.esq.altura = level + 1;
                    queue.offer(aux.esq);
                }
                
                if (aux.dir != null) {
                    aux.dir.altura = level + 1;
                    queue.offer(aux.dir);
                }
            }
        }
        
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            String s = sc.nextLine();
            char[] t = toInfix(s);
            Btree tree = new Btree(t);
            tree.BFS();
            if(sc.hasNext())
                System.out.print("\n\n");
            else
                System.out.print("\n");
        }
    }
}
