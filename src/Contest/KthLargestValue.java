package Contest;

import java.util.PriorityQueue;

public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for(int i=1;i<m;i++){
            dp[0][i] = dp[0][i-1]^matrix[0][i];
        }
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0]^matrix[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]^dp[i][j-1]^dp[i-1][j-1]^matrix[i][j];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)-> b-a);
        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                pq.add(dp[i][j]);
            }
        }
        int ans = 0;
        while(k>0){
            ans = pq.poll();
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        KthLargestValue kv = new KthLargestValue();
        int[][] arr = {{5,2},{1,6}};
        int [][] ans = {{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}
};
       int x = kv.kthLargestValue(ans,1);
       System.out.println(x);
    }
}
