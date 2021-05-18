package binarysearch;

public class SudokuValidator {
    public boolean solve(int[][] matrix) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(!isvalid(matrix,i,j,matrix[i][j]))
                    return false;
            }
        }
        return true;
    }

    public boolean isvalid(int[][]matrix,int row,int col,int val){
        for(int i=0;i<9;i++){
            if(matrix[i][col]==val&&i!=row){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(matrix[row][j]==val&&j!=col){
                return false;
            }
        }
        int rowr = row - row%3;
        int colc = col - col%3;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[rowr+i][colc+j]==val && (rowr+i)!= row && (colc+j)!=col)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuValidator sv = new SudokuValidator();
        int [][] matrix= {
            {4, 2, 6, 5, 7, 1, 3, 9, 8},
            {8, 5, 7, 2, 9, 3, 1, 4, 6},
            {1, 3, 9, 4, 6, 8, 2, 7, 5},
            {9, 7, 1, 3, 8, 5, 6, 2, 4},
            {5, 4, 3, 7, 2, 6, 8, 1, 9},
            {6, 8, 2, 1, 4, 9, 7, 5, 3},
            {7, 9, 4, 6, 3, 2, 5, 8, 1},
            {2, 6, 5, 8, 1, 4, 9, 3, 7},
            {3, 1, 8, 9, 5, 7, 4, 6, 2}
        };
        System.out.println(sv.solve(matrix));

    }
}
