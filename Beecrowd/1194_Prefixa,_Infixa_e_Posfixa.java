import java.util.*;

public class Main
{
    static class Node
    {
        char letra;
        Node esq;
        Node dir;
        
        Node (char letra)
        {
            this.letra = letra;
            this.esq = null;
            this.dir = null;
        }
    }
    static class Btree
    {
        Node raiz;
        int preInd = 0;
        
        Btree(char in[], char pre[]) {
            raiz = MontaArvore(in, pre, 0, pre.length - 1);
        }
        
        /* Monta a arvore a partir dos passeios in e pre ordem */
        Node MontaArvore(char in[], char pre[], int inInicio, int inFim)
        {
            if (inInicio > inFim)
                return null;
            
            /* Pega o elemento atual do passeio preordem e cria um no */
            Node aux = new Node(pre[preInd]);
            /* Incrementa */
            preInd++;
            
            /* Se não ha filhos, termine */
            if (inInicio == inFim)
                return aux;
            
            /* Caso contrario encontre o no atual no passeio inordem */
            int inInd = busca(in, inInicio, inFim, aux.letra);
            
            /* Como no inordem, a subarvore da esquerda ta na esquerda da raiz
            e a subarvore direita ta na direita da raiz, continuamos recursivamente*/
            aux.esq = MontaArvore(in, pre, inInicio, inInd - 1);
            aux.dir = MontaArvore(in, pre, inInd + 1, inFim);
            
            return aux;
        }
        
        int busca(char arr[], int start, int end, char value)
        {
            int i;
            for (i = start; i <= end; i++) {
                if (arr[i] == value)
                    return i;
            }
            return i;
        }
        
        void print() {
            print(raiz);
        }
        
        void print(Node no)
        {
            if(no == null)
                return;
                
            print(no.esq);
            print(no.dir);
            
            System.out.print(no.letra);
            
        }
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(sc.next());
            
            char[] pre = sc.next().toCharArray();
            char[] in = sc.next().toCharArray();
            sc.nextLine();
            
            Btree tree = new Btree(in, pre);
            
            tree.print();
            
            System.out.print("\n");
        }
    }
}
