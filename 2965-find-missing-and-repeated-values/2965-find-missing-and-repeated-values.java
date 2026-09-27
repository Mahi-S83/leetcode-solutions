class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int total=n*n;
        int xor=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                xor^=grid[i][j];
            }
        }
        for(int i=1;i<=total;i++)
        {
            xor^=i;
        }
        int group1=0;
        int group2=0;
        int bit=xor&(-xor);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((grid[i][j]& bit)!=0)
                {
                    group1^=grid[i][j];
                }
                else
                group2^=grid[i][j];
            }
        }
          for (int i = 1; i <= total; i++) {// Put expected numbers 1 to n² into the same groups

            if ((i & bit) != 0) {
                group1 ^= i;
            } else {
                group2 ^= i;
            }
        }
        int rep;
        int miss;
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==group1)
                count++;
            }
        }
        if(count==2)
        {
            rep=group1;
            miss=group2;
        }
        else
        {
            rep=group2;
            miss=group1;
        }
return new int[]{rep,miss};
    }
}