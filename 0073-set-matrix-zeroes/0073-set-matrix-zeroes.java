class Solution {
    public void setZeroes(int[][] matrix) {

        List<Integer> i_0 = new ArrayList<Integer>();
        List<Integer> j_0 = new ArrayList<Integer>();

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    i_0.add(i);
                    j_0.add(j);
                }
            }
        }

        for(int i : i_0)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                matrix[i][j] = 0;
            }
        }

        for(int j : j_0)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][j] = 0;
            }
        }
        
    }
}