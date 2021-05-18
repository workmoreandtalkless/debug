package Pramp;

public class DetectPattern {
    public boolean containsPattern(int[] arr, int m, int k) {
        int length = arr.length;
        int cnt = 1 ;
        if(length/m < k) return false;

        int point1 = 0 ;
        int point2 = point1+m ;

        while(point2<length){
            if(arr[point1]!=arr[point2]){
                point1++;
                point2=point1+m;
            }
            else{
                if(isrepeat(arr,point1,point2,m)){
                    point1=point1+m;
                    point2=point1+m;
                    cnt++;
                    if(cnt>=k) return true;
                }
                else{
                    point1++;
                    point2 = point1+m;
                }
            }
        }

        return cnt>=k;



    }

    public boolean isrepeat(int []arr, int a, int b,int m){
        if(b>arr.length-1) return false;
        for(int i=a;i<a+m;i++){
            if(b<arr.length&&arr[i]==arr[b++]){
                continue;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int []arr = {1,2,1,2,1,1,1,3};
        int []arr1 = {6,3,5,5,5,5,1,5,6,2,5,1,2,5,3,5,1,3,5,5,6,4,1,2};
        int m=2;
        int k=2;
        DetectPattern dp = new DetectPattern();
        boolean x= dp.containsPattern(arr,m,k);
        boolean y = dp.containsPattern(arr1,1,5);
        System.out.print(x);
    }
}
