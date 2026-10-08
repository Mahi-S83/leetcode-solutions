class Solution {
    public String removeOuterParentheses(String s) {
       StringBuilder ans=new StringBuilder();
       int count=0;
       for(char ch:s.toCharArray())
       {
        if(ch=='(')
       { if(count>0)
        ans.append("(");
        count++;}
        else
        {
            count--;
            if(count>0)
            ans.append(")");
        }

       } return ans.toString();
    }
}