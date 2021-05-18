package Contest;

import java.util.Arrays;

public class MaximumUnitsOnaTrack {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{
            return b[1]-a[1];
        });

        int un = 0;
        for(int i=0;i<boxTypes.length;i++){
            int n = boxTypes[i][0];
            int u = boxTypes[i][1];
            if(truckSize>=n){
                truckSize-=n;
                un+=n*u;
            }else{
                un+=truckSize*u;
            }
        }
        return un;
    }

    public static void main(String[] args) {
        int [][] arr ={
                {5,10},
                {2,5},
                {4,7},
                {3,9}
        };
        int size = 10;

        MaximumUnitsOnaTrack mot = new MaximumUnitsOnaTrack();
        int x = mot.maximumUnits(arr,size);
        System.out.println(x);
    }
}
