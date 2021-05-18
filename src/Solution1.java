import Week1.Sol;

import java.util.*;

public class Solution1 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        Map<Integer,Integer> map = new HashMap();
        int [] arr = new int[n+1];
        for(int i=0;i<rounds.length;i++){
            if(i==0){
                arr[rounds[i]]++;
                continue;
            }
            int start = rounds[i-1];
            int end = rounds[i];
            for(int j = start+1;j<=end;j++){
                arr[j]++;
            }
        }
        List<Integer> list = new LinkedList();
        int max = arr[1];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]) max = arr[i];
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==max)
                list.add(i);
        }
        return list;
    }


    public static void main(String[] args) {
        int n=4;
        int [] arrs = {1,3,1,2};
        Solution1 so = new Solution1();
       List<Integer> list = so.mostVisited(4,arrs);
        for (int a :
                list) {
            System.out.print(a+" ");
        }
    }
}
