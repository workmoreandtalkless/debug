package L1600_1699;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaximumErasureValue {
    /**
    public int maximumUniqueSubarray(int[] nums) {
        int max = nums[0];
        int sum = 0;
//        Set<Integer> set = new HashSet();
        Map<Integer,Integer> map = new HashMap();
        int i=0;
        int low = 0;
        while(low<nums.length){
            i=low;
            while(i<nums.length){
                if(map.containsKey(nums[i])){
                    sum = Sum(map);
                    max = Math.max(sum,max);
                    i=map.get(nums[i])+1;
                    map.clear();
                    break;
                }
                map.put(nums[i],i);
                i++;
            }
            low = i;
            sum = Sum(map);
            max = Math.max(sum,max);
        }


        return max;

    }
    public int Sum(Map<Integer,Integer> map){
        int sum=0;
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            sum+=entry.getKey();
        }
        return sum;
    }
    */
    /** force method
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashSet set = new HashSet();
        for(int start = 0;start<n;start++){
            //reset set and current sum for next subarray
            set.clear();
            int currentSum = 0;
            for(int end = start;end<n && !set.contains(nums[end]);end++){
                currentSum +=nums[end];
                set.add(nums[end]);
            }
            res = Math.max(res,currentSum);
        }
        return res;
    }
    */
    /** two pointer with set
    public int maximumUniqueSubarray(int[] nums){
        int res = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            //increment start until subarray has unique elements
            while(set.contains(nums[end])){
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum +=nums[end];
            set.add(nums[end]);
            res = Math.max(res,currentSum);
        }
        return res;
     }*/
    public int maximumUniqueSubarray(int[] nums){
        int res = 0;
        int curSum = 0;
        int start = 0;
        boolean [] isPresent = new boolean[10001];
        for (int end = 0; end < nums.length; end++) {

            while (isPresent[nums[end]]==true){
              isPresent[nums[start]]=false;
              curSum-=nums[start];
              start++;
            }
            curSum += nums[end];
            isPresent[nums[end]] = true;
            res = Math.max(res,curSum);

        }
        return res;
    }
    public static void main(String[] args) {
        int [] n = {4,2,4,5,6};
        MaximumErasureValue mev = new MaximumErasureValue();
        mev.maximumUniqueSubarray(n);
    }
}
