class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        int top=0;
        int down=n-1;
        int left=0;
        int right=n-1;
        int num=1;
        while(top<=down && left <=right)
        {//filling array
          //left to right
          for(int col=left;col<=right;col++)
           {
            mat[top][col]=num++;
           }top++;
           //top down
           for(int row=top;row<=down;row++)
           {
            mat[row][right]=num++;
           }right--;
           //right to left
           if (top <= down) {
              
                for (int col = right; col >= left; col--)
                    mat[down][col]=num++;
                down--;
            }

                if (left <= right) {
                // bottom → top
                for (int row = down; row >= top; row--)
                    mat[row][left]=num++;
                left++;
            }
        }
        return mat;
    }
}