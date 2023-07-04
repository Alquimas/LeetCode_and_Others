class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for(int i = 0; i < nums.length; i++)
        {
            ans ^= nums[i];
        }
        return ans;
    }
}
//anotacao para o eu do futuro
// A XOR A = 0
// A XOR B XOR A = B
// Entao cada elemento repetido vai se anular
// e so vai restar o único que não se repete 
