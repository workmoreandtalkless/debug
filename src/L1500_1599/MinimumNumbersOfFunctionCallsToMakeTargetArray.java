package L1500_1599;

public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int res = 0, maxLen =0;
        for(int a: nums){
            int bits = 0;
            while(a>0){
                res+=a&1;
                bits++;
                a>>=1;
            }
            maxLen = Math.max(maxLen,bits);
        }
        return res + maxLen - 1;
    }
    public int minOperations1(int[] nums) {
        int max= 0;
        int ans=nums.length-1;
        int need =0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]) max = nums[i];
            // if(nums[i]%2!=0){
            //     int close = closeN(nums[i]);
            //     int need =
            // }
        }
        if(max%2!=0){
            need = closeN(max);
        }

        else{
            need = closeN(max);
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2!=0){
                    need+=closeNE(nums[i]);
                }
            }
        }
        return ans+need;

    }

    public int closeN(int n){
        int i = 1;
        int cnt=0;
        int left =0;
        for(i=1;;i*=2){

            if(i>n) break; // i will be larger than 1000000000.
            left = n-i;
            cnt++;
        }


        return cnt+left;
    }

    public int closeNE(int n){
        int i = 1;
        int cnt=0;
        int left =0;
        for(i=1;;i*=2){

            if(i>n) break;
            left = n-i;
            cnt++;
        }


        return left;
    }


    public static void main(String[] args) {
        int nums[] = {1000000000};
        MinimumNumbersOfFunctionCallsToMakeTargetArray ma= new MinimumNumbersOfFunctionCallsToMakeTargetArray();
        //int x = ma.minOperations(nums);
        int y = ma.minOperations1(nums);
        System.out.println(y);
    }
}
