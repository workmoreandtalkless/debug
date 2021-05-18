package Contest;

public class FairArray {
    public int waysToMakeFair(int[] a) {
       int n = a.length;
       int []b = new int[n+1];
       int []c = new int[n+1];
        for (int i = 0; i < n; i++) {
            b[i+1] = a[i] - b[i];
            c[i+1] = a[n-1-i] - c[i];
        }
        int results = 0;
        for(int i=0;i<n;i++){
            if(b[i]==c[n-1-i]){
                ++results;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int []nums ={2,1,6,4};
        FairArray fa= new FairArray();
        fa.waysToMakeFair(nums);
    }
}
