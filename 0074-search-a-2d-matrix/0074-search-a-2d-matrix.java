class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
        {
            return false;
        }

        int i = binary(matrix, target);

        if (i == 1) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    public int binary(int matrix[][], int target) {
        int low = 0;
        int high = matrix.length - 1;
        int mid;

        while (low <= high) 
        {
            mid = low + (high - low) / 2;

            if (matrix[mid][0] == target) 
            {
                return 1;
            }
            if (matrix[mid][0] < target) 
            {
                low = mid + 1;
            }
            if (matrix[mid][0] > target) 
            {
                high = mid - 1;
            }
        }

        int row = high;
        if (row < 0) return -1;

        int x = 0;
        int z = matrix[0].length - 1;
        int y;

        while (x <= z) 
        {
            y = x + (z - x) / 2;
            if (matrix[row][y] == target) 
            {
                return 1;
            }
            if (matrix[row][y] < target) 
            {
                x = y + 1;
            } else 
            {
                z = y - 1;
            }
        }

        return -1;
    }
}
