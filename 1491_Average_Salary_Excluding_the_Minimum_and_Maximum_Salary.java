class Solution {
    public double average(int[] salary) 
    {
        int soma = 0;
        int salarioMaximo = 999;
        int salarioMinimo = 10*10*10*10*10*10+1;

        for(int i=0; i<salary.length; i++)
        {
            soma=soma+salary[i];
            salarioMinimo = Math.min(salarioMinimo, salary[i]);
            salarioMaximo = Math.max(salarioMaximo, salary[i]);
        }
        
        return ((double) (soma - salarioMinimo - salarioMaximo)/(salary.length-2)); 
    }
}
