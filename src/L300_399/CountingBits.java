package L300_399;

public class CountingBits {
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = popcount(i);
        return ans;
    }
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
            x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        CountingBits cb= new CountingBits();
        int arr[]=cb.countBits1(n);
    }
}
