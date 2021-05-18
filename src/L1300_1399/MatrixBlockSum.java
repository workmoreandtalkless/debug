package L1300_1399;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] sumMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    sumMatrix[i][j] = mat[i][j];
                    continue;
                }
                if (i == 0) {
                    sumMatrix[i][j] = sumMatrix[i][j - 1] + mat[i][j];
                    continue;
                }
                if (j == 0) {
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + mat[i][j];
                    continue;
                }
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + mat[i][j];
            }
        }
        int[][] blockSumMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                blockSumMatrix[i][j] = findBlockSumMatrix(sumMatrix, i, j, n, m, K);
            }
        }
        return blockSumMatrix;
    }

    private int findBlockSumMatrix(int[][] sumMatrix, int i, int j, int n, int m, int k) {
        int i1 = Math.max(i - k, 0);
        int j1 = Math.max(j - k, 0);
        int i2 = Math.min(i + k, n - 1);
        int j2 = Math.min(j + k, m - 1);

        int ABCD = sumMatrix[i2][j2];
        int AB = (i1 > 0) ? sumMatrix[i1 - 1][j2] : 0;
        int AC = (j1 > 0) ? sumMatrix[i2][j1 - 1] : 0;
        int A = (i1 > 0 && j1 > 0) ? sumMatrix[i1 - 1][j1 - 1] : 0;

        return ABCD - AB - AC + A;
    }

    public static void main(String[] args) {
        MatrixBlockSum m = new MatrixBlockSum();
        int [][]mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
       int ans[][] = m.matrixBlockSum(mat,1);
    }

}