package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataAnaysis {
    public double mean(int[] arr){
        double ans = 0;
        int n = arr.length;
        int sum = 0;
        for(int i: arr){
            sum+=i;
        }
        ans = sum/n;
        return ans;
    }

    public double median(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        double ans = 0;
        if(n%2==0){
            int f = arr[n/2-1];
            int s = arr[n/2];
            ans = (f+s)/2;
        }else{
            ans = arr[n/2];
        }
        return ans;
    }

    public int mode(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int max = 0;
        int ans = 0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(val>max) {
                max = val;
                ans = key;
            }
        }

        return ans;
    }

    public double sd(int[] arr){
        double mean = mean(arr);
        int n = arr.length;
        double sum = 0;
        for (int x: arr
             ) {
            sum +=Math.pow(x-mean,2);
        }

        double ans = Math.sqrt(sum/n);
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = { 80, 100, 100, 80, 110, 70, 90};
        DataAnaysis da = new DataAnaysis();
        double mean = da.mean(arr);
        double median = da.median(arr);
        int mode = da.mode(arr);
        double sd = da.sd(arr);

        System.out.println("mean : "+ mean);
        System.out.println("median : "+ median);
        System.out.println("mode : "+ mode);
        System.out.println("standard deviation : "+ sd);

    }
}
