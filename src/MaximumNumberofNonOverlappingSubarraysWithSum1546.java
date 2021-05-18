import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberofNonOverlappingSubarraysWithSum1546 {
    public int maxNonOverlapping(int[] A, int T) {
        int sum=0;
        int dp[]=new int[A.length];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(sum==T){
                dp[i]=1;
            }
            int com = sum-T;
            if(map.containsKey(com))
            {
                dp[i]=Math.max(dp[i],dp[map.get(com)]+1);
            }
            dp[i]=Math.max(dp[i],get(dp,i-1));
            map.put(sum,i);
        }
        int res=0;
        for(int i:dp)
            res=Math.max(res,i);
        return res;
    }
    public int get(int A[],int i){
        if(i<0)return 0;
        return A[i];
    }

    public int max(int []nums, int target){
        Set<Integer> prefix = new HashSet<>();
        prefix.add(0);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefix.contains(sum - target)) {
                ans++;
                prefix.clear();
                prefix.add(0);
                sum = 0;
            } else {
                prefix.add(sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        //int []nums ={1,1,1,1,1};
        int []nums1 ={-1,3,5,1,4,2,-9};
        MaximumNumberofNonOverlappingSubarraysWithSum1546 m = new MaximumNumberofNonOverlappingSubarraysWithSum1546();
        int T =6;
        //int x =m.maxNonOverlapping(nums1,T);
        int y = m.max(nums1,T);
        System.out.print(y);

    }
}
