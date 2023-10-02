class Solution {
    public boolean winnerOfGame(String c) {
        int alice = 0;
        int bob = 0;

        for(int i = 0; i < c.length(); i++)
        {
            if(c.charAt(i) == 'A')
            {
                int counter = 0;
                while(i < c.length() && c.charAt(i) == 'A')
                {
                    counter++;
                    i++;
                }
                alice += Math.max(counter - 2, 0);
            }
            if(i < c.length() && c.charAt(i) == 'B')
            {
                int counter = 0;
                while(i < c.length() && c.charAt(i) == 'B')
                {
                    counter++;
                    i++;
                }
                bob += Math.max(counter - 2, 0);
                i--;
            }
        }

        return (alice - bob) > 0;
    }
}
