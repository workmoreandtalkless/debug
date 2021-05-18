import java.util.Arrays;
public class CanConvertStringinKMoves {
    public boolean can(String s, String t, int k){
        if(s.length()!=t.length()) return false;
        int [] arr = new int[s.length()];

        for(int i=0;i<s.length();i++){
            int s1=t.charAt(i)-'a';
            int s2=s.charAt(i)-'a';
            if(s1>=s2)
                arr[i]=t.charAt(i)-s.charAt(i);
            else{
                int temp = ('z'-'a') +(t.charAt(i)-'a')- (s.charAt(i)-'a');
                arr[i]= temp;
            }
        }
        Arrays.sort(arr);
        int ith=-1;
        /**
         *  for(int i=0;i<arr.length;i++){
         *             if(arr[i]<0){
         *                 int temp = Math.abs(arr[i]);
         *             }
         *         }
         *
         *
         *
         */


        for(int i=0;i<arr.length;i++){

            if(ith==arr[i]){
                ith+=26;
                if(ith>k) return false;
                else continue;
            }
            if(arr[i]!=0){
                if(ith<arr[i]){
                    ith=arr[i];
                    if(ith<=k)
                        continue;
                    else return false;
                }else return false;

            }
            else{
                continue;
            }
        }
        return true;


    }


    public static void main(String[] args) {
        CanConvertStringinKMoves c = new CanConvertStringinKMoves();
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
        boolean x=c.can(s,t,k);
        System.out.print(x);
    }
}
