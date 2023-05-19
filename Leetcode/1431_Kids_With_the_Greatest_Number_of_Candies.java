class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        List retorno = new ArrayList();
        int maior=0;
        for(int i: candies)
        {
            if(i > maior)
            {
                maior = i;
            }
        }
        for(int i: candies)
        {
            if(maior - i <= extraCandies)
                retorno.add(true);
            else
                retorno.add(false);
        }

        return retorno;
    }
}
