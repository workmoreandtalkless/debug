package Contest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Arithmetic {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new LinkedList();
        for(int i=0;i<l.length;i++){
            int a= l[i];
            int b=r[i];
            int len = b - a + 1;
            int arr[] = new int[len];
            int index = 0;
            for(int j=a;j<=b;i++){
                arr[j-a]=nums[j];
            }
            Arrays.sort(arr);
            list.add(isT(arr));
        }
        return list;
    }
    public boolean isT(int []nums){
        if(nums.length<2) return false;
        int value = nums[1]-nums[0];
        for(int i=2;i<nums.length;i++){
            int temp = nums[i]-nums[i-1];
            if(temp!=value) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Arithmetic ar = new Arithmetic();
        List<Boolean> list = new LinkedList<>();
       int [] nums = {4,6,5,9,3,7};
       int [] l = {0,0,2};
        int [] r = {2,3,5};

        list = ar.checkArithmeticSubarrays(nums,l,r);
    }
}
