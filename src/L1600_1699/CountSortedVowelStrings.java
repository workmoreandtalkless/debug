package L1600_1699;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        return countVowelStringUtil(n, 5);
    }

    int countVowelStringUtil(int n, int vowels) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        return countVowelStringUtil(n - 1, vowels) +
                countVowelStringUtil(n, vowels - 1);
    }

    public static void main(String[] args) {
        CountSortedVowelStrings csvs = new CountSortedVowelStrings();

        int n = 2;
        int x = csvs.countVowelStrings(n);
        System.out.println(x);
    }
}
