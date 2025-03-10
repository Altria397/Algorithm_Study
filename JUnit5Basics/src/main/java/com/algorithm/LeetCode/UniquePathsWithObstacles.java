package com.algorithm.LeetCode;

/*
   Description: 63. 不同路径 II
   Author: 叁玖柒
   Date: 2025/1/23
   Time: 9:42
*/
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;

        // 初始化动态规划数组，dp[i][j] 表示到达位置(i,j)的路径数
        int[][] dp = new int[m][n];

        // 起点是否可达：如果起点不是障碍物，则路径数为1；否则返回0
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        } else {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                // 如果当前位置是障碍物，则路径数为0
                if (obstacleGrid[i][j] != 1) {
                    int up = i > 0 ? dp[i-1][j] : 0;
                    int left = j > 0 ? dp[i][j-1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        // 示例输入
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid)); // 输出：2
    }
}
