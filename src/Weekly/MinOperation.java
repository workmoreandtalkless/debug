package Weekly;

public class MinOperation {
    public int minDays(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        // arr[i] represent the miminist step to eat the last one.
        // int [][] arr = new arr[n][n];
        int [] arr = new int[n+1];

        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        int min1= Integer.MAX_VALUE;
        int min2= Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        for(int i=3;i<n;i++){
            index3 = i-1;
            if(i%2==0){
                index1 = i-(i/2);
                min1 = Math.min(arr[index1],arr[index3]);
            }
            if(i%3==0){
                index2 = i-2*(i/3);
                min2 = Math.min(arr[index2],arr[index3]);
            }

            min=Math.min(min1,min2);

            //System.out.print("i:"+i+" ");
            //System.out.print("min:"+min+" ");

            arr[i]=min+1;
            //System.out.println("arr["+i+"]"+ arr[i]);
        }

        return arr[n];

    }

    public static void main(String[] args) {
        int n=84806671;
        MinOperation m = new MinOperation();
        int x=m.minDays(n);
        System.out.println(x);
    }



}
