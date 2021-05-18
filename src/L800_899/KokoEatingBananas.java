package L800_899;

import java.util.Arrays;

public class KokoEatingBananas {

        public int minEatingSpeed(int[] piles, int H) {
            int lo = 1;
            int hi = 1_000_000_000;
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                if (!possible(piles, H, mi))
                    lo = mi + 1;
                else
                    hi = mi;
            }

            return lo;
        }

        // Can Koko eat all bananas in H hours with eating speed K?
        public boolean possible(int[] piles, int H, int K) {
            int time = 0;
            for (int p: piles)
                time += (p-1) / K + 1;
            return time <= H;
        }

    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int H = 8;
        int [] piles1 = {30,11,23,4,20};
        int H1 = 5;
      KokoEatingBananas k = new KokoEatingBananas();
      int x = k.minEatingSpeed(piles1,H1);
      int y = k.minEatingSpeed(piles,H);
      System.out.println(x);
      System.out.println(y);
    }
}
