import java.util.Arrays;
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        char[] chars = s.toCharArray();
        char[] save = new char[s.length()+1];
        int j = 1;
        for(int i = 0; i<s.length(); i++)
        {
            if(chars[i] == '{' || chars[i] == '[' || chars[i] == '(')
            {
                save[j] = chars[i];
                j++;
            }
            if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')')
            {
                if(chars[i] == '}')
                {
                    if(save[j-1] == '{')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(chars[i] == ']')
                {
                    if(save[j-1] == '[')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(chars[i] == ')')
                {
                    if(save[j-1] == '(')
                    {
                        j--;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }
        if(j > 1)
            return false;

        return true;
    }
}

/*Uma solucao mais polida que eu gostei e que usa ED
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (c == '{') // if the character is an opening brace
                stack.push('}'); // push the corresponding closing brace onto the stack
            else if (c == '[') // if the character is an opening bracket
                stack.push(']'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}
*/
