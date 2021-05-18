public class CanConvertStringinKMoves1 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        // Array to store the next usable difference
        int diffArr[] =new int[27] ;

        char sChar, tChar;
        int diff;
        for (int i=0; i<s.length(); i++) {
            sChar = s.charAt(i);
            tChar = t.charAt(i);
            if (sChar == tChar) {
                continue;
            }

            diff = (tChar - sChar);
            diff += ((diff < 0) ? 26 : 0); // If we go from 'z' to 'a', diff is negative, so we add 26 to make it positive (circular)

            if (diff + diffArr[diff] > k) {
                return false;
            }

            // Increase the diff value by 26 if we happen to find it again with some other character
            diffArr[diff] += 26;
        }

        return true;
    }
    public static void main(String[] args) {
        CanConvertStringinKMoves1 c = new CanConvertStringinKMoves1();
        /**
         *  String s = "iqssxdlb";
         *         String t =  "dyuqrwyr";
         *         int k=40;
         */

        /**
         String s = "atmtxzjkz";
         String t =  "tvbtjhvjd";
         int k=35;
         */

        String s = "mpzzwh";
        String t =  "kaeblv";
        int k=24;
        boolean x=c.canConvertString(s,t,k);
        System.out.print(x);
    }
}
