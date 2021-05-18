package Contest;

public class GFG {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i-1]+nums[i];
        }
        int past = 0;
        int rem = sums[n-1];
        int rn = n;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            rem -= nums[i];
            rn--;
            ans[i] = nums[i]*i-past+rem-nums[i]*rn;
            past = sums[i];
        }
        return ans;
    }

    // Driver program
    public static void main(String[] args) {
        int []nums = {1,4,6,8,10};
        GFG s = new GFG();
        int [] res = s.getSumAbsoluteDifferences(nums);
    }
}
