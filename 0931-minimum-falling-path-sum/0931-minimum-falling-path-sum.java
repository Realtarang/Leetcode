// recursion
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int ans = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             ans = Math.min(ans, help(n - 1, j, matrix));
//         }
//         return ans;
//     }
//     int help(int i, int j, int[][] matrix) {
//         if (i == 0) {
//             return matrix[i][j];
//         }
//         int left = (int) 1e9;
//         int down = (int) 1e9;
//         int right = (int) 1e9;
//         if (j > 0) {
//             left = matrix[i][j] + help(i - 1, j - 1, matrix);
//         }
//         if (j < matrix.length - 1) {
//             right = matrix[i][j] + help(i - 1, j + 1, matrix);
//         }
//         down = matrix[i][j] + help(i - 1, j, matrix);
//         return Math.min(down, Math.min(left, right));
//     }
// }

// memoization
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int[][] dp = new int[n][n];
//         for (int[] it : dp) {
//             Arrays.fill(it, -1);
//         }
//         int ans = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             ans = Math.min(ans, help(n - 1, j, matrix, dp));
//         }
//         return ans;
//     }

//     int help(int i, int j, int[][] matrix, int[][] dp) {
//         if (i == 0) {
//             return matrix[i][j];
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int left = (int) 1e9;
//         int down = (int) 1e9;
//         int right = (int) 1e9;
//         if (j > 0) {
//             left = matrix[i][j] + help(i - 1, j - 1, matrix, dp);
//         }
//         if (j < matrix.length - 1) {
//             right = matrix[i][j] + help(i - 1, j + 1, matrix, dp);
//         }
//         down = matrix[i][j] + help(i - 1, j, matrix, dp);
//         return dp[i][j] = Math.min(down, Math.min(left, right));
//     }
// }

// tabulation 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int left = (int) 1e9;
                int down = (int) 1e9;
                int right = (int) 1e9;
                if (j > 0) {
                    left = matrix[i][j] + dp[i + 1][j - 1];
                }
                if (j < n - 1) {
                    right = matrix[i][j] + dp[i + 1][j + 1];
                }
                down = matrix[i][j] + dp[i + 1][j];
                dp[i][j] = Math.min(down, Math.min(left, right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}