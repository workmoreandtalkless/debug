package L000_099;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0]==1){
                for (int j = i; j < m; j++) {
                    dp[j][0]=0;
                }
                break;
            }
            dp[i][0]=1;
        }

        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i]==1){
                for (int j = i; j < n; j++) {
                    dp[0][j]=0;
                }
                break;
            }
            dp[0][i]=1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0}};

        UniquePathsII u = new UniquePathsII();
        int x=u.uniquePathsWithObstacles(arr);
        System.out.println(x);
    }
}
