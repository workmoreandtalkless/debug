package Contest;

import java.util.*;

public class MaximumSumObtainedOfAnyPermutation {
    int mod = 1000000007;
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0;i<requests.length;i++){
            int first = requests[i][0];
            int second = requests[i][1];
            for(int j= first;j<=second;j++){
                map.put(j,map.getOrDefault(j,0)+1);
            }
        }
        Map<Integer,Integer> mp1= sortByValue(map);
        Arrays.sort(nums);
        long res = 0;
        int index = nums.length -1 ;
        for(Map.Entry<Integer,Integer> bb : mp1.entrySet()){
            int temp1= bb.getKey();
            int temp2= bb.getValue();
            long temp3 = (long)nums[index--];

            while(temp2>0){
                res+= temp3;
                res%=mod;
                temp2--;
            }
        }
        return (int)res;
    }

    private Map<Integer, Integer> sortByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        HashMap<Integer,Integer> temp = new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> aa : list){
            temp.put(aa.getKey(),aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        int []nums ={1,2,3,4,5};
        int [][] requests={{1,3},{0,1}};
        MaximumSumObtainedOfAnyPermutation msop= new MaximumSumObtainedOfAnyPermutation();
        int x= msop.maxSumRangeQuery(nums,requests);
        System.out.print(x);
    }
}
