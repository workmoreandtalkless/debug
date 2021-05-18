public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j <= n; ++j)
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
                    ans++;
        return ans;
    }

    public static void main(String[] args) {
        CountRangeSum maze = new CountRangeSum();
        int []nums = {-2,5,-1};
        int lower =-2;
        int upper =2;
        int x=maze.countRangeSum(nums,lower,upper);
        System.out.println(x);
    }
}
