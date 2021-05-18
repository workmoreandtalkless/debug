package L1500_1599;

public class GetMaxLen {
    public int getMaxLen(int[] nums) {
        int even = -1, odd = -2, res = 0, neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // reset everytime you met a zero;
                neg = 0;
                even = i;
                odd = -2;
            } else {
                if (nums[i] < 0) neg++;  // number of negatives from last zero or head of array
                if (neg == 1 && odd == -2) odd = i;   // init odd cnt neg;
                if (neg % 2 == 0) res = Math.max(res, i - even);  //if curr cnt neg is even;
                else if (odd > -2) res = Math.max(res, i - odd);  // first odd after last zero;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int [] arr = {-1,-2,-3,0,1};
        GetMaxLen gml = new GetMaxLen();
        int x=gml.getMaxLen(arr);
        System.out.print(x);
    }
}
