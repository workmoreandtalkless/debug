package Contest;

public class REformatPhoneNumber {
    public String reformatNumber(String number) {
        int l = number.length();
        StringBuilder newstr = new StringBuilder();
        for(char c: number.toCharArray()){
            if(Character.isDigit(c)){
                newstr.append(c);
            }
        }
        int newl = newstr.length();
        int index = newl;
        StringBuilder res = new StringBuilder();
        int start = 0;
        while(index>4){

            res.append(newstr.charAt(start));
            res.append(newstr.charAt(start+1));
            res.append(newstr.charAt(start+2));
            res.append('-');
            index-=3;
            start+=3;
        }
        if(index == 2){
            res.append(newstr.charAt(start));
            res.append(newstr.charAt(start+1));
        }else if(index == 3){
            res.append(newstr.charAt(start));
            res.append(newstr.charAt(start+1));
            res.append(newstr.charAt(start+2));
        }else if(index ==4){
            res.append(newstr.charAt(start));
            res.append(newstr.charAt(start+1));
            res.append('-');
            res.append(newstr.charAt(start+2));
            res.append(newstr.charAt(start+3));
        }

        return res.toString();
    }

    public static void main(String[] args) {
        REformatPhoneNumber rpn = new REformatPhoneNumber();
        String number = "123 4-567";
        String s = rpn.reformatNumber(number);
        System.out.print(s);
    }
}
