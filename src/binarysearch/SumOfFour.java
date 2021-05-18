package binarysearch;

public class SumOfFour {
    public boolean solve(int[] nums,int k){
        if(nums.length<4){
            return false;
        }
        return dfs(nums,0,k,0);
    }

    private boolean dfs(int[] nums, int index, int k, int count){
        if(k==0 && count ==4){
            return true;
        }
        if(count==4 || index + (3-count)>=nums.length){
            return false;
        }
        return dfs(nums,index+1,k-nums[index],count+1)||dfs(nums,index+1,k,count);
    }

    public static void main(String[] args) {
        int [] res = {10, 3, 5, 9, 4, 0};
        int k=17;

        SumOfFour sf = new SumOfFour();
        sf.solve(res,k);
    }
}
