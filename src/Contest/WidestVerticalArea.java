package Contest;

import java.util.Arrays;

public class WidestVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(a, b)->a[0]-b[0]);
        int [] resw = new int[points.length];
        int [] resh = new int[points.length];
        for(int i=1;i<points.length;i++){
            int y = points[i][1];
            int y1= points[i-1][1];
            int x = points[i][0];
            int x1 = points[i-1][0];
            resw[i]=x-x1;
            resh[i]=y1-y;
        }

        int m = resw[0];
        int index =0;
        for(int i=0;i<resw.length;i++){
            int tmp = resw[i];
            if(tmp>m){
                m=tmp;
                index = i;
            }
            if(tmp==m){
                if(resh[i]>resh[index])
                {
                    index = i;
                }
            }
        }

        return m;
    }

    public static void main(String[] args) {
        int [][] nums ={
                {8,7},
                {9,9},
                {7,4},
                {9,7}
        };

        WidestVerticalArea wva = new WidestVerticalArea();
        int x = wva.maxWidthOfVerticalArea(nums);
    }
}
