package Contest;

public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int l=0;


        int [][] pro= new int[n+1][n+1];
        long temp=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j) temp = nums[i-1];
                else
                    temp = nums[i-1]*nums[j-1];
                int zero = i-1;
                if(temp>0) pro[i][j]=Math.max(pro[i][j-1],i-j+1);
                else if(temp==0) {
                    zero = j;
                    pro[i][j]=pro[i][j-1];
                }
                else{
                    int tmp = j - zero;
                    pro[i][j]=Math.max(pro[i][j-1],tmp);
                }

            }
        }

        for(int i=1;i<n+1;i++){

            l=Math.max(pro[i][n],l);

        }

        return l;



    }

    public static void main(String[] args) {
        int []nums = {-1,-2,-3,0,1};
        GetMaxLen gml = new GetMaxLen();
        int x= gml.getMaxLen(nums);
        System.out.print(x);
    }
}
