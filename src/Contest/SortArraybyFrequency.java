package Contest;

import java.util.*;

public class SortArraybyFrequency {
    public int[] frequencySort(int[] nums) {
        Arrays.sort(nums);
//         int s = nums[0];
//         int e = nums[nums.length-1];
//         int l = e-s+1;
//         int [] arr = new int[l-1];
//         if(s>0){
//             for(int i=0;i<nums.length;i++){

//             }
//         }
        int [] n = new int[nums.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i =0 ;i<nums.length;i++){
            int x = nums[i];
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }

        }
        PriorityQueue<List<Integer>> p = new PriorityQueue<List<Integer>>((a, b)->{

            if(a.size()==b.size()) return b.get(0) - a.get(0);
            else return a.size() - b.size();

        });
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x = entry.getKey();
            int y = entry.getValue();
            List<Integer> list = new LinkedList();
            for(int i =0;i<y;i++){
                list.add(x);
            }
            p.add(list);
        }


        while(!p.isEmpty()){
            List<Integer> l = p.poll();
            for(int i=0;i<l.size();i++){
                n[index++]=l.get(i);
            }

        }
        return n;



    }

    public static void main(String[] args) {
        SortArraybyFrequency sa = new SortArraybyFrequency();
        int []nums ={1,1,2,2,2,3};
        int []n = new int[nums.length];
        n=sa.frequencySort(nums);

    }
}
