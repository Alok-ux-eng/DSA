class Solution 
{
    public boolean isPalindrome(String s) 
    {
        String str = "";
        for(char ch : s.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            str = str + "" + Character.toLowerCase(ch);
        }

        for(int i = 0; i < str.length()/2;i++)
        {
            char ch_left = str.charAt(i);
            char ch_right = str.charAt(str.length()-i-1);
            if(!(ch_left==(ch_right)))
            return false;

        }

        return true;
    }
}