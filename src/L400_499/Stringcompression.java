package L400_499;

import java.util.LinkedList;
import java.util.List;

public class Stringcompression {
    public int compress(char[] chars) {
        List<Character> list = new LinkedList<>();
        list.add(chars[0]);
        int cnt=1;
        for (int i = 1; i < chars.length; i++) {
            char tmp = chars[i];
            if(tmp == chars[i-1]){
                cnt++;
            }else{
                if(cnt==1){
                    list.add(tmp);
                }
                else{
                    char c= (char)(cnt +'0');
                    list.add(c);
                    list.add(tmp);
                    cnt=1;
                }
            }
        }
        list.add((char)(cnt+'0'));
        return list.size();
    }
    public int compress1(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        char  [] arr ={'a','a','b','b','c','c','c'};
        Stringcompression s = new Stringcompression();
        int x= s.compress1(arr);
        System.out.println(x);
    }
}
