package binarysearch;



public class MaxValue {
    public static int max(int[] arr){
        int n = arr.length;
        int []ans = new int[n+1];
        for(int i=0;i<n;i++){
            ans[i+1] = Math.max(ans[i+1],ans[i]);
            ans[i+1] = Math.max(ans[i+1],arr[i]+(i==0?0:ans[i-1]));
        }
        return ans[n];
    }

    public static void main(String[] args) {
        int []arr = new int[]{2,1,7,9};
        int x = MaxValue.max(arr);
        System.out.println(x);
    }
}
