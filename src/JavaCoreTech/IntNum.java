package JavaCoreTech;

public class IntNum {
    private static int x;



    public static void main(String[] args) {
        x = 1_000_000;
        System.out.println("x:" + x);
        double dou = 2-1.1;
        System.out.println("double: "+ dou);

        char c = '\u03C0';
        char d = '\u005B';
        char e = '\u005D';
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        char aa = '\u0022';
        char bb = '\u0022';
        System.out.println(aa + "hello" + bb);
    }
}


