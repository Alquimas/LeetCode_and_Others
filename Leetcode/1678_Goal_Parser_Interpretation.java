class Solution {
    public String interpret(String command) {
        StringBuilder myString = new StringBuilder();

        for(int i = 0; i < command.length(); i++)
        {
            if(command.charAt(i) == 'G')
            {
                myString.append('G');
                continue;
            }
            if(command.charAt(i + 1) == ')')
            {
                myString.append('o');
                i++;
                continue;
            }
            myString.append('a');
            myString.append('l');
            i += 3;
        }

        return myString.toString();
    }
}
