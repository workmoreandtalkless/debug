package Contest;

import java.util.Arrays;
import java.util.Comparator;

public class MiniDeletion {
    public int minDeletions(String s) {
        int fre[] = new int[26];
        for(char c:  s.toCharArray()){
            int index = (int) c-'a';
            fre[index]++;
        }

        for(int i=0;i<fre.length-1;i++){
            for(int j=i+1;j<fre.length;j++){
                if(fre[j]>fre[i]){
                    int tmp = fre[i];
                    fre[i] = fre[j];
                    fre[j] = tmp;
                }
            }
        }
        int c = 0;
        for(int i=1;i<fre.length;i++){
            if(fre[i]==0) break;
            if(fre[i]-fre[i-1]==0){
                fre[i]--;
                c++;
                if(fre[i]==0) break;

            }
        }
        return c;

    }

    public static void main(String[] args) {
        String s = "abcabc";
//        String s1 = "aaabbbcc";
//        String s2 = "ceabaacb";
        MiniDeletion md = new MiniDeletion();
        int x = md.minDeletions(s);
//        int x1 = md.minDeletions(s1);
//        int x2 = md.minDeletions(s2);
//        System.out.println("x:" + x + "x1: "+ x1 + "x2: "+ x2);
        System.out.println(x);
    }
}
