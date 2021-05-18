import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Arrays.compare;

public class Solution2 {
    public int maxCoins(int[] piles) {
        //  Arrays.sort(piles,new Comparator<Integer>(){
        //     @Override
        //     public int compare(int a, int b){
        //         return b-a;
        //     }
        //  });
        for(int i=0;i<piles.length-1;i++ ){
            for(int j=i+1;j<piles.length;j++){
                if(piles[j]>piles[i]){
                    int temp=piles[i];
                    piles[i]=piles[j];
                    piles[j]=temp;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]);
        }

        int res =0;
        int n = piles.length/2;
        for(int i = 0;i<2*n;i++){
            int tmp = piles[i];
            if(i%2!=0)
                res+=pq.remove();
            else
                pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arrs = {2,4,1,2,7,8};
        Solution2 so = new Solution2();
        int x=so.maxCoins(arrs);
        System.out.println(x);
    }
}
