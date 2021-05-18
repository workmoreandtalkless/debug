import java.util.HashMap;
import java.util.Map;

public class Merging2Packages {
    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // your code goes here
        if(arr.length==0||arr.length==1) return new int[0];
        int [] res= new int[2];
        //force algorithm
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==limit-arr[i]){
                    if(i>=res[1])
                        res= new int[]{j,i};
                }
            }

        }


        return res;
    }




    public static void main(String[] args) {
        int [] arr = {4, 6, 10, 15, 16};
        Merging2Packages mp = new Merging2Packages();
        for (int i:
                mp.getIndicesOfItemWeights(arr,21)) {
            System.out.print(i+" ");
        }


    }

}
