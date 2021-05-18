package Contest;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    int ptr ;
    String [] arr;

    public OrderedStream(int n) {
        arr = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {
        arr[id-1]=value;
        List<String> list = new ArrayList();
        String s = arr[ptr];
        if(arr[ptr]==null){
            return list;
        }
        else {

            for(int i = ptr;i<arr.length;i++){
                if(arr[i]!=null){
                    list.add(arr[i]);
                }
                else {
                    ptr = i;
                    break;
                }
            }
            return list;
        }

    }

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        os.insert(3,"ccccc");
        os.insert(1,"aaaaa");
        os.insert(2,"bbbbb");
        os.insert(5,"eeeee");
        os.insert(4,"ddddd");

    }
}
