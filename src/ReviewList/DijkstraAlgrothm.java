package ReviewList;


import java.util.Arrays;
import java.util.PriorityQueue;

class DijkstraAlgrothm {
        int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        class Cell{
            int x;
            int y;
            Integer difference;
            Cell(int x,int y,Integer difference){
                this.x = x;
                this.y = y;
                this.difference = difference;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int row = heights.length;
            int col = heights[0].length;
            int [][] differenceMatrix = new int[row][col];

            for(int[] eachRow : differenceMatrix){
                Arrays.fill(eachRow,Integer.MAX_VALUE);
            }
            differenceMatrix[0][0] = 0;
            PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b)->(
                    a.difference.compareTo(b.difference)));

            boolean[][] visited = new boolean[row][col];
            queue.add(new Cell(0,0,differenceMatrix[0][0])); // diferenceMatrix[0][0] is 0

            while(!queue.isEmpty()){
                Cell curr = queue.poll();
                visited[curr.x][curr.y] = true;

                if(curr.x==row-1&&curr.y == col-1){
                    return differenceMatrix[curr.x][curr.y];
                }

                for(int[] direction: directions){
                    int adjacentX = curr.x + direction[0];
                    int adjacentY = curr.y + direction[1];
                    if(isValidCell(adjacentX,adjacentY,row,col)&&!visited[adjacentX][adjacentY]){
                        int tempres = heights[adjacentX][adjacentY];
                        int temnext = heights[curr.x][curr.y];
                        int currentDifference = Math.abs(heights[adjacentX][adjacentX]-heights[curr.x][curr.y]);
                        int maxDifference = Math.max(currentDifference,differenceMatrix[curr.x][curr.y]);
                        if(differenceMatrix[adjacentX][adjacentY]>maxDifference){
                            differenceMatrix[adjacentX][adjacentY]=maxDifference;
                            queue.add(new Cell(adjacentX,adjacentY,maxDifference));
                        }

                    }
                }


            }
            return differenceMatrix[row-1][col-1];
        }
        boolean isValidCell(int x,int y,int row,int col){
            return x>=0 &&x<=row-1&& y>=0&&y<=col-1;
        }

    public static void main(String[] args) {
        int [][] heights ={
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        DijkstraAlgrothm da = new DijkstraAlgrothm();
        int x = da.minimumEffortPath(heights);
    }
}

