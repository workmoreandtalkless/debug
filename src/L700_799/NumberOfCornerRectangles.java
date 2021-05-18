package L700_799;

import java.util.HashMap;
import java.util.Map;

public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        Map<Integer,Integer> count = new HashMap();
        int ans = 0;
        for(int [] row : grid){
            for(int c1 = 0;c1<row.length; ++c1){
                if(row[c1]==1){
                    for(int c2 = c1 +1;c2<row.length;++c2){
                        if(row[c2]==1){
                            int pos = c1*200 + c2;
                            int c = count.getOrDefault(pos,0);
                            ans += c;
                            count.put(pos,c+1);
                        }
                    }

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfCornerRectangles ncr = new NumberOfCornerRectangles();
        int [][] grid ={
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        int x = ncr.countCornerRectangles(grid);
        System.out.println(x);
    }
}
