package Weekly;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution3 {
    public int findLatestStep(int[] arr, int m) {
        /**
         * create a bit with all o
         * follow the arr to convert the bit
         * check the size of group
         * return the last step
         */
        int last = -1 ;
        Set<Integer> list = new HashSet<>();
        int n = arr.length;
        int num = 1;
        for (int i = 0; i < n; i++) {
            num <<= 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];

            int con = move(tmp);
            num = num|con;

            int copy = num;

            list = check(copy,n);

            for (int x :
                    list) {
                if (x == m)
                    last = i+1;
            }


        }
        return last;

    }
    public  Set<Integer> check(int num,int n){
        int count =0;
        int group =0;
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < n-1; i++) {

            if((num&1) == 1){
                count++;
                group=count;
                group=Math.max(group,count);
            }
            else{
                count=0;
            }
            list.add(group);
            num >>=1;
        }
        return list;
    }
    public int move(int a){
        int num =1;
        for(int i=0;i<a-1;i++){
            num<<=1;
        }
        return num;
    }

    public static void main(String[] args) {
        int arr[]={3,5,1,2,4};
        Solution3 so = new Solution3();
        so.findLatestStep(arr,1);
    }
}
