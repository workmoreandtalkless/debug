package binarysearch;

public class MaximumScorefromPerformingMultiplicationOperations {
    int n,m;
    int[] nums,muls;
    Integer[][] mark;
    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;
        this.nums = nums;
        this.muls = muls;
        this.mark = new Integer[n][n];
        return help(0,0);
    }

    public int help(int start,int index){

        if(index==m) return 0;
        if(mark[start][index]!=null){
            return mark[start][index];
        }

        int sum1 = help(start+1,index+1) + muls[index]*nums[start];
        int sum2 = help(start,index+1) + muls[index]*nums[n-(index-start)-1];

        return mark[start][index]=Math.max(sum1,sum2);
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
       int[] multipliers = {3,2,1};
       MaximumScorefromPerformingMultiplicationOperations msp = new MaximumScorefromPerformingMultiplicationOperations();
       msp.maximumScore(nums,multipliers);

    }
}
