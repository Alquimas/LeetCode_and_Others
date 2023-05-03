class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pilha = new Stack<Integer>();
        int j=0;
        for(int i: pushed)
        {
            pilha.push(i);
            while(!pilha.empty())
            {
                if(pilha.peek() == popped[j])
                {
                    pilha.pop();
                    j++;
                    continue;
                }
                break;
            }
        }
        while(!pilha.empty())
        {
            if(pilha.peek() != popped[j])
            {
                return false;
            }
            pilha.pop();
            j++;
        }
        return true;
    }
}
