package Contest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int []copy = new int[heights.length];

        int []needs =new int[heights.length];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(
                (a,b)-> b-a
        );
        int index = 0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[i-1]){
                needs[i]=heights[i]-heights[i-1];
            }
        }
        for(int i=0;i<needs.length;i++){
            copy[i]=needs[i];
        }
        Arrays.sort(copy);
        for(int i=0;i<needs.length;i++){
            bricks-=needs[i];
            if(needs[i]>0)
                q.add(needs[i]);
            if(bricks<=0){
                if(ladders<=0&&bricks==0) return i;
                if(ladders<=0) return i-1;
                else{
                    ladders--;
                    bricks+=q.poll();
                }

            }
        }
        return index;

    }

    public static void main(String[] args) {
        int[] h ={1,2,3,4,5};
        int b=1;
        int l=1;
        FurthestBuilding fb = new FurthestBuilding();
        int x = fb.furthestBuilding(h,b,l);
        System.out.println(x);
    }
}
