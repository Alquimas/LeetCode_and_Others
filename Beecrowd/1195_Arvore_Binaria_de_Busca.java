import java.util.*;

public class Main
{
    static class Node
    {
        int conteudo;
        Node esq;
        Node dir;
        
        Node (int conteudo)
        {
            this.conteudo = conteudo;
            this.esq = null;
            this.dir = null;
        }
    }
    static class Btree
    {
        Node raiz;
        
        void add(int a) {
            if(raiz == null) {
                raiz = new Node(a);
            }
            else {
                add(raiz, a);
            }
        }
        
        void add(Node root, int a) {
            if(a < root.conteudo)
            {
                if(root.esq == null)
                    root.esq = new Node(a);
                else
                    add(root.esq, a);
            }
            else
            {
                if(root.dir == null)
                    root.dir = new Node(a);
                else
                    add(root.dir, a);
            }
        }
        
        String preOrdem() {
            return preOrdem(raiz);
        }
        
        String preOrdem(Node no) {
            if(no == null)
                return "";
                
            String s = "";
                
            s += " " + no.conteudo;
            s += preOrdem(no.esq);
            s += preOrdem(no.dir);
            
            return s;
        }
        
        String inOrdem() {
            return inOrdem(raiz);
        }
        
        String inOrdem(Node no) {
            if(no == null)
                return "";
                
            String s = "";
                
            s += inOrdem(no.esq);
            s += " " + no.conteudo;
            s += inOrdem(no.dir);
            
            return s;
        }
        
        String posOrdem() {
            return posOrdem(raiz);
        }
        
        String posOrdem(Node no) {
            if(no == null)
                return "";
            
            String s = "";
                
            s += posOrdem(no.esq);
            s += posOrdem(no.dir);
            s += " " + no.conteudo;
            
            return s;
        }
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < n; i++) {
            Btree tree = new Btree();
            String s = "";
            
            int a = Integer.parseInt(sc.nextLine());
            
            for(int j = 0; j < a; j++)
            {
                tree.add(Integer.parseInt(sc.next()));
            }
            sc.nextLine();
            
            s += "Case " + (i + 1) + ":\n";
            s += "Pre.:";
            s += tree.preOrdem();
            s += "\nIn..:";
            s += tree.inOrdem();
            s += "\nPost:";
            s += tree.posOrdem();
            s += "\n\n";
            
            System.out.print(s);
        }
    }
}
