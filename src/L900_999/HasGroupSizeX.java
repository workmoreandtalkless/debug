package L900_999;

import java.util.ArrayList;
import java.util.List;

public class HasGroupSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        List<Integer> values = new ArrayList();
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0)
                values.add(count[i]);

        search: for (int X = 2; X <= N; ++X)
            if (N % X == 0) {
                for (int v: values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }

    public static void main(String[] args) {
        int []deck = new int[]{1,1,1,2,2,2,3,3,3};
        HasGroupSizeX h= new HasGroupSizeX();
       boolean x=h.hasGroupsSizeX(deck);
    }
}
