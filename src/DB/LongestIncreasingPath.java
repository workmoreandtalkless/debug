package DB;

public class LongestIncreasingPath {
    public int solve(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxlength = 0;
        int [][]mark = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                maxlength = Math.max(dfs(matrix,i,j,mark),maxlength);
            }
        }
        return maxlength;
    }
    public int dfs(int [][]matrix,int r,int c,int[][]mark){
        if(mark[r][c]!=0) return mark[r][c];
        int cur = matrix[r][c]; //4
        int up = r,down=r;
        int right =c, left = c;
        if(--up>=0&&matrix[up][c]>cur){
            mark[r][c] = Math.max(dfs(matrix,up,c,mark),mark[r][c]);
        }
        if(++down<matrix.length&&matrix[down][c]>cur){
            mark[r][c] = Math.max(dfs(matrix,down,c,mark),mark[r][c]);
        }
        if(++right<matrix[0].length&&matrix[r][right]>cur){
            mark[r][c] = Math.max(dfs(matrix,r,right,mark),mark[r][c]);
        }
        if(--left>=0&&matrix[r][left]>cur){
            mark[r][c] = Math.max(dfs(matrix,left,c,mark),mark[r][c]);
        }

        return ++mark[r][c];

    }

    public static void main(String[] args) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        int [][] m= {{38,29,84,50}};
        lip.solve(m);
    }
}
