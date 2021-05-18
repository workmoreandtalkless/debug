package OA;

public class PrintPattern2 {
    public static void print2(int row){
        for(int i=0;i<=row;i++){
            char ch = 'a';
            char print = ch;
            for(int j=0;j<=i;j++){
                System.out.print((print++));
            }
            System.out.println();
        }
    }
    public static void print3(int row){
        char ch = 'a';
        char print = ch;
        for(int i=1;i<=row;i++){
            for(int j=0;j<=i;j++){
                System.out.print((print++));
            }
            System.out.println();
        }
    }

    public static void print4(int row){
        int x = 1;
        for(int i=1;i<=row;i++){
            for(int j=i;j>0;j--){
                System.out.print(x+""+x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintPattern2 pp = new PrintPattern2();
        pp.print2(3);
        pp.print3(3);
        pp.print4(3);
    }
}
