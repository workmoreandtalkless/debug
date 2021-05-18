package Dynamic;

public class Knapsack416_2 {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i: nums)
            sum += i;

        if(sum % 2 != 0) return false;

        return helper(nums.length - 1, nums, 0, sum/2);
    }

    private boolean helper(int i, int[] nums, int sum, int target) {
        if(i < 0 || sum > target)
            return false;

        if(nums[i] > target)
            return false;

        if(sum == target)
            return true;

        return helper(i-1, nums, sum+nums[i], target) ||
                helper(i-1, nums, sum, target);

    }

    public static void main(String[] args) {
        Knapsack416_2 s=new Knapsack416_2();
        int [] nums={1,5,11,5};
        boolean boo = s.canPartition(nums);
        System.out.println(boo);
    }
}
