package binarysearch;

public class lcsts {
    public int solve(String a, String b, String c) {
        int m = a.length();
        int n = b.length();
        int k = c.length();
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i][0] = 0;
        }
        for (int i = 0; i < k + 1; i++) {
            dp[0][0][k] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    for (int l = 1; l < k; l++) {
                        if (a.charAt(i - 1) == c.charAt(l - 1)) {
                            dp[i][j][l] = dp[i - 1][j - 1][l - 1] + 1;
                        } else {
                            dp[i][j][l] = Math.max(
                                    dp[i - 1][j][l], Math.max(dp[i][j - 1][l], dp[i][j][l - 1]));
                        }
                    }
                }
            }
        }
        return dp[m][n][k];
    }

    public static void main(String[] args) {
        lcsts lcs = new lcsts();
        lcs.solve("epidemiologist","refrigeration","supercalifragilisticexpialodocious");
    }
}
