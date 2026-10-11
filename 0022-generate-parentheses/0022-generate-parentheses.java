class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate(res,"",0,0,n);
        return res;
    }
    private void generate(List<String> res, String brack,int open,int close,int n )
    {
        if(brack.length()==2*n)
        {
            res.add(brack);

        }
        if(open<n)
        {
            generate(res,brack+"(",open+1,close,n);
        }
        if(close<open)
        {
            generate(res,brack+")",open,close+1,n);
        }
    }
    }
