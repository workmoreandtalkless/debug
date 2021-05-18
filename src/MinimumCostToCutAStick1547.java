import java.net.SocketOption;
import java.util.*;

public class MinimumCostToCutAStick1547 {
    public int minCost(int n, int[] cuts) {
        List<Integer> A = new ArrayList<>();
        for(int a: cuts){
            A.add(a);
        }
        A.add(0);
        A.add(n);
        Collections.sort(A);
        int k = A.size();
        int [][]dp = new int[k][k];
        for(int d =2;d<k;++d){//why begin from 2?
          for(int i=0;i<k-d;++i){
              dp[i][i+d] = Integer.MAX_VALUE;
              for(int m = i+1;m<i+d;++m){
                  dp[i][i+d] = Math.min(dp[i][i+d],dp[i][m]+dp[m][i+d]+A.get(i+d)-A.get(i));
              }
          }
        }
        return dp[0][k-1];
    }
    public int min (int n, int [] cutsOrder){
        int[] A = new int[cutsOrder.length+2];
        Arrays.sort(cutsOrder);
        System.arraycopy(cutsOrder, 0, A, 1, cutsOrder.length);
        A[A.length-1] = n;
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length - 2; i++) dp[i][i+2] = A[i+2] - A[i];
        for (int len = 4; len <= A.length; len++) {
            for (int i = 0; i + len - 1 < A.length; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k <= j-1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
                dp[i][j] += A[j] - A[i];
            }
        }
        return dp[0][A.length-1];
    }
    public static void main(String[] args) {
        int [] cuts ={5,6,1,4,2};
        int n=9;

        MinimumCostToCutAStick1547 m = new MinimumCostToCutAStick1547();
        //int x = m.minCost(n,cuts);
        int x = m.min(n,cuts);
        System.out.print(x);
    }
}
