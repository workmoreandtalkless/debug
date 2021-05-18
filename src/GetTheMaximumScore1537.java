public class GetTheMaximumScore1537 {

    public int maxSum(int[] nums1, int[] nums2) {
        int i=0,j=0,n = nums1.length, m= nums2.length;
        long a=0,b=0, mod = (long)1e9 +7;
        while(i<n||j<m){
            if(i<n&&(j==m||nums1[i]<nums2[j])){
                a+=nums1[i++];
            }else if(j<m && (i==n || nums1[i]>nums2[j])){
                b+=nums2[j++];
            }else{
                a=b=Math.max(a,b)+nums1[i];
                i++;j++;
            }
        }

        return (int)(Math.max(a,b)%mod);

    }

    public static void main(String[] args) {
        int []a={4,6,8,9};
        int []b={2,4,5,8,10,11};
        GetTheMaximumScore1537 get= new GetTheMaximumScore1537();
        int x=get.maxSum(a,b);
        System.out.println(x);
    }
}
