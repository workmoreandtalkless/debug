package Challenge;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> l = new ArrayList();
        sub(nums,0,list,l);
        return list;
    }

    public void sub(int[] nums,int s,List<List<Integer>> list,List<Integer> template){

        list.add(new ArrayList(template));
        for(int i=s;i<nums.length;i++){
            template.add(nums[i]);
            sub(nums,i+1,list,template);
            template.remove(template.size()-1);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        subsets sst = new subsets();
        sst.subsets(nums);
    }
}
