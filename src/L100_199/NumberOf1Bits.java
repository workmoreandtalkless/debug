package L100_199;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    public static void main(String[] args) {
        int n=10;
        NumberOf1Bits nob = new NumberOf1Bits();
        int x = nob.hammingWeight(n);
        System.out.println(n);
    }
}
