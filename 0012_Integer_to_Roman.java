class Solution {
    public String intToRoman(int num) {
        StringBuilder myString = new StringBuilder();
        while(num >= 1000)
        {
            myString.append('M');
            num-=1000;
        }
        if(num >= 900)
        {
            myString.append('C');
            myString.append('M');
            num-=900;
        }
        if(num >= 500)
        {
            myString.append('D');
            num-=500;
        }
        if(num >= 400)
        {
            myString.append('C');
            myString.append('D');
            num-=400;
        }
        while(num >= 100)
        {
            myString.append('C');
            num-=100;
        }
        if(num >= 90)
        {
            myString.append('X');
            myString.append('C');
            num-=90;
        }
        if(num >= 50)
        {
            myString.append('L');
            num-=50;
        }
        if(num >= 40)
        {
            myString.append('X');
            myString.append('L');
            num-=40;
        }
        while(num >= 10)
        {
            myString.append('X');
            num-=10;
        }
        if(num >= 9)
        {
            myString.append('I');
            myString.append('X');
            num-=9;
        }
        if(num >= 5)
        {
            myString.append('V');
            num-=5;
        }
        if(num >= 4)
        {
            myString.append('I');
            myString.append('V');
            num-=40;
        }
        while(num >= 1)
        {
            myString.append('I');
            num-=1;
        }
        return myString.toString();
    }
}
