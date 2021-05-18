package Dynamic;

import java.util.Arrays;

public class Knapsack416 {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums){
            sum += num;
        }
        /*
          if((sum&1)==1){
            return false;
            }
         */
        // dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
        sum /= 2;
        int n= nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], false);
        }
        dp[0][0] = true;//zero number consists of sum 0 is true;

        for(int i=1;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<sum+1;j++){
            dp[0][j] = false;
        }

        for(int i=1;i<n+1;i++){
            for (int j = 1; j <sum+1 ; j++) {
                dp[i][j] = dp[i-1][j];//if we don't pick it,which means if the first i-1 elements has made it to j.
                if(j>=nums[i-1]){
                    dp[i][j] =(dp[i][j]||dp[i-1][j-nums[i-1]]);//represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers.
                }
            }
        }

        return dp[n][sum];

    }

    public static void main(String[] args) {
        Knapsack416 knapsack = new Knapsack416();
        int [] nums={1,5,11,5};
        /**dp[][]
         * [1,0,0,0,0,0,0,0,0,0,0,0]
         * [1,1,0,0,0,0,0,0,0,0,0,0]
         * [1,1,0,0,0,1,1,0,0,0,0,0]
         * [1,1,0,0,0,1,1,0,0,0,0,1]
         * [1,1,0,0,0,1,1,0,0,0,1,1]
         */
        int []nums1={1,2,3,5};
        int sum=11;
        System.out.println((sum&1));
        int y=22;
        int []arr = new int[33];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        for(int a:arr){
            System.out.print((a&1)+" ");
        }
        System.out.println();
        System.out.println(knapsack.canPartition(nums1));
    }
}
