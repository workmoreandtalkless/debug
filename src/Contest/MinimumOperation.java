package Contest;

public class MinimumOperation {
    public int minOperations(int[] a, int x) {
        int n = a.length;
        int q = 0;
        int s = 0;
        for(int i = 0;i < n;i++){
            s += a[i];
        }
        int ans = 9999999;
        for(int i = 0;i <= n;i++){
            while((s > x || q <= i) && q < n){
                s -= a[q++];
            }
            if(s == x){
                ans = Math.min(ans, i+(n-q));
            }
            if(i < n)s += a[i];
        }
        return ans <= n+1 ? ans : -1;
    }

    public static void main(String[] args) {
        int []nums = {1,1,4,2,3};
        int x = 5;
        MinimumOperation mo = new MinimumOperation();
        mo.minOperations(nums,x);
    }
}
