package Week1;

public class minFlip {
    public int minFlips(String target){
        int length = target.length();
        int first = target.indexOf("1");
        if(first==length) return 0;
        char flag = '0';
        int count=0;
        while (first<length){
            if(flag!=target.charAt(first)){
                count++;
                flag = target.charAt(first);
            }
            first++;
        }
        return count;
    }

    public static void main(String[] args) {
//        String x="10111";
//        String y="101";
        String z="00000";
        minFlip mf=new minFlip();
//        int x1=mf.minFlips(x);
//        int y1=mf.minFlips(y);
        int z1=mf.minFlips(z);
//        System.out.println(x1);
//        System.out.println(y1);
        System.out.println(z1);
    }
}
