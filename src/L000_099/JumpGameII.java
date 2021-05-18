package L000_099;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int [] sofarbest = new int[nums.length];
        Arrays.fill(sofarbest,0);
        int lastp = nums.length-1;
        int leaststep = 0;
        for(int i=nums.length-2;i>=0;i--){
            leaststep = sofarbest[i+1];
            int furthestp = Math.min(i+nums[i],nums.length-1);
            for(int j=i+1;j<=furthestp;j++){
                leaststep = Math.min(sofarbest[j],leaststep);
            }
            sofarbest[i]=leaststep+1;

        }
        return sofarbest[0];
    }

    public static void main(String[] args) {
        int []nums = {2,3,0,1,4};
        JumpGameII jg = new JumpGameII();
        System.out.print(jg.jump(nums));
    }
}
