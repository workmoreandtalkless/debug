package L1500_1599;

import java.util.Arrays;

public class MaxSumRangeQuery {

    public int maxSumRangeQuery(int[] A, int[][] req) {
        int res = 0, mod = (int)1e9+7, n = A.length;
        int [] count = new int [n];
        for(int [] r: req ){
            count[r[0]]+=1;
            if(r[1]+1<n)
                count[r[1]+1]-=1;
        }
        for(int i = 1;i<n;++i){
            count[i]+=count[i-1];
        }
        Arrays.sort(A);
        Arrays.sort(count);
        for(int i=0;i<n;++i)
            res = (res + A[i]*count[i])%mod;
        return res;
    }

    public static void main(String[] args) {
        int []nums ={1,2,3,4,5};
        int [][] requests={{1,3},{0,1}};

        int []nums1 ={1,2,3,4,5,10};
        int [][] requests1={{0,2},{1,3},{1,1}};

        MaxSumRangeQuery msr= new MaxSumRangeQuery();
        int x = msr.maxSumRangeQuery(nums1,requests1);
        System.out.print(x);
    }
}
