package L1500_1599;

import java.util.HashSet;
import java.util.Set;

public class DetectCyclesIn2DGrid {

    public boolean containsCycle(char[][] grid) {
        /**
         * store all the lowercase letters
         * from the first position to right and down to see if they can meet
         * check all this letter , to see weather the letter is false return false
         * else return true
         */

        // store all the lowercase letters
        Set<Character> set = new HashSet<>();
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[0].length; j++) {
                mark[i][j]=false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                set.add(grid[i][j]);
            }
        }
        //go through all the letter
        int n= set.size();
        Character []a = new Character[n];
        a =(Character [])set.toArray(a);

        for (int i = 0; i < a.length; i++) {
            int x=-1;
            int y=-1;
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                        if(grid[j][k]==a[i]){
                            x=i;
                            y=j;
                            break;
                        }
                }
                if(x!=-1&&y!=-1) break;
            }
            dfs(grid,a[i],mark,x,y);
        }

        for (int i = 0; i < a.length; i++) {
            if(check(a[i],grid,mark)){
                return true;
            }
        }

        return false;

    }
    public boolean check(char a,char[][]grid,boolean[][]mark){
        for (int j = 0; j < grid.length; j++) {
            for (int k = 0; k < grid[0].length; k++) {
                if(grid[j][k]==a&&mark[j][k]==false) {return false;}
            }
        }
        return true;
    }
    public void dfs(char[][] grid, char a,boolean[][] mark,int x,int y){
            if(x<0||x>=grid.length||y<0||y<=grid[0].length) return;
            if(grid[x][y]!=a) return;
            mark[x][y]=true;
            if(x>=0&&x<grid.length){
                dfs(grid,a,mark,x+1,y);
            }
            if(y>=0&&y<grid[0].length)
                dfs(grid,a,mark,x,y+1);
    }

    public static void main(String[] args) {
        char[][] grid={
                {'a','a','a','a'},
                {'a','b','b','a'},
                {'a','b','b','a'},
                {'a','a','a','a'}
        };
        DetectCyclesIn2DGrid dc= new DetectCyclesIn2DGrid();
        boolean is=dc.containsCycle(grid);
        System.out.println(is);
    }

}
