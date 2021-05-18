package Contest;

public class SumOf {
    public int[] getSumAbsoluteDifferences(int[] nums) {

        int l= nums.length;
        int[][] res = new int[l][l];
        int []ans = new int[l];
        for(int j=0;j<l;j++){
            res[0][j] = Math.abs(nums[j]-nums[0]);
        }
        for(int i=1;i<l;i++){
            for(int j=i;j<l;j++){
                if(j==i){
                    res[i][j] = Sum(res,i,j);
                }
                else{
                    res[i][j] = Math.abs(nums[i] - nums[j]);
                }

            }
        }
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                ans[i]+=res[i][j];
            }
        }

        return ans;

//         for(int i=0;i<l;i++){
//             ans[i] = cal(nums,i);

//         }
//         return ans;
    }
    public int cal(int []nums,int index){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.abs(nums[i]-nums[index]);
        }
        return sum;
    }
    public int Sum(int [][] res, int r,int c){
        int sum = 0;
        for(int i=0;i<=c;i++){
            sum+=res[i][c];
        }
        return sum;
    }

    public static void main(String[] args) {
        int []nums = {1,4,6,8,10};
        SumOf s = new SumOf();
        int [] res = s.getSumAbsoluteDifferences(nums);
    }
}
