import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());
        int c = Integer.parseInt(sc.next());

        while(!(a == 0 && b == 0 && c == 0))
        {
            Lista myList = new Lista(a);

            int[] saida = myList.remove(b, c);
            int last = 0;
            
            for(int i = 0; i < 2*a; i++)
            {
                if(saida[i] == 0) break;
                if(saida[i] != last)
                    System.out.printf("%3d", saida[i]);
                last = saida[i];
                if(i % 2 == 1 && i != 2*a - 1 && saida[i+1] != 0)
                {
                    System.out.print(",");
                }
            }
            System.out.print("\n");

            sc.nextLine();

            a = Integer.parseInt(sc.next());
            b = Integer.parseInt(sc.next());
            c = Integer.parseInt(sc.next());
        }
    }
    static class Lista
    {
        int tam;
        Node cabeca;
        
        Lista(int k)
        {
            this.tam = k;
            this.cabeca = new Node(1);

            Node aux = cabeca;

            for(int i = 1; i < k; i++)
            {
                Node novo = new Node(i + 1);

                aux.setProx(novo);
                novo.setAnt(aux);
                aux = novo;
            }

            aux.setProx(cabeca);
            cabeca.setAnt(aux);
        }

        public int[] remove(int a, int b)
        {
            int[] retorno = new int[2*tam];
            int m = 0;
            
            Node aa = this.cabeca;
            Node bb = this.cabeca.getAnt();

            while(this.tam != 0)
            {
                if(tam == 1)
                {
                    tam--;
                    retorno[m] = aa.getConteudo();
                    retorno[m+1] = aa.getConteudo();
                    return retorno;
                }
                for(int i = 0; i < a - 1; i++)
                {
                    aa = aa.getProx();
                }
                for(int i = 0; i < b - 1; i++)
                {
                    bb = bb.getAnt();
                }

                if(aa.getConteudo() == bb.getConteudo())
                {
                    retorno[m] = aa.getConteudo();
                    retorno[m+1] = aa.getConteudo();
                    
                    remove(aa);
                    
                    aa = aa.getProx();
                    bb = bb.getAnt();
                    
                    m+=2;
                    tam--;
                }
                else
                {
                    retorno[m] = aa.getConteudo();
                    remove(aa);
                    m++;
                    
                    retorno[m] = bb.getConteudo();
                    remove(bb);
                    m++;
                    
                    if(aa.getProx() == bb)
                    {
                        aa = bb.getProx();
                    }
                    else
                    {
                        aa = aa.getProx();
                    }
                    bb = bb.getAnt();
                    
                    tam -= 2;
                }
            }

            return retorno;
        }
        public void remove(Node aux)
        {
            aux.getAnt().setProx(aux.getProx());
            aux.getProx().setAnt(aux.getAnt());
        }
    }
    static class Node
    {
        private int conteudo;
        private Node prox;
        private Node ant;

        Node(int conteudo)
        {
            this.conteudo = conteudo;
            this.prox = null;
            this.ant = null;
        }
        
        public int getConteudo() { return this.conteudo; }

        public Node getProx() { return this.prox; }

        public Node getAnt() { return this.ant; }
        
        public void setProx(Node prox) { this.prox = prox; }

        public void setAnt(Node ant) { this.ant = ant; }
    }
}
