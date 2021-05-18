package Contest;

import java.util.regex.Pattern;

public class ReorderSpaces {
    public String reorderSpaces(String text) {
        char[] str= text.toCharArray();
        // calculate the space
        int space =0;
        String s="";
        for (int i = 0; i < str.length; i++) {
            if(str[i]==32)
                space++;
        }
        int word=0;
        String [] strings = text.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals("")){
                word++;
            }
        }
        if(word==1){
            if(space==0)
            for (int i = 0; i <strings.length ; i++){
                if(strings[i].equals("")) continue;
                else {
                    s = strings[i];
                }

            }
            if(space!=0)
                for (int i = 0; i <strings.length ; i++){
                    if(strings[i].equals("")) continue;
                    else {
                        s = strings[i];
                        while(space>0){
                            s+=" ";
                            space--;
                        }
                        break;
                    }

                }
            return s;
        }else{
            int cnt = space/(word-1);
            int rem = space%(word-1);
            for (int i = 0; i <strings.length ; i++) {
                if(strings[i].equals("")) continue;
                else {
                    s+=strings[i];
                    int tmp = cnt;
                    if(i!=strings.length-1){
                    while(tmp>0){
                        s+=" ";
                        tmp--;
                    }
                    }
                    else{
                        while(rem>0){
                            s+=" ";
                            rem--;
                        }
                    }
                }
            }
            return s;
        }

    }

    public static void main(String[] args) {
        String text="  hello";

        ReorderSpaces rs= new ReorderSpaces();
        String s = rs.reorderSpaces(text);
        System.out.print(s);

    }
}
