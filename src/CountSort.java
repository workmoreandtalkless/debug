import java.util.*;

public class CountSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++)
            map.put(arr2[i], i);

        int n = arr2.length;
        List<Integer> list = new ArrayList<>();
        for (int i : arr1)
            list.add(i);

        Collections.sort(list , (Integer a, Integer b) -> {
            boolean aInMap = map.containsKey(a);
            boolean bInMap = map.containsKey(b);
            if (aInMap && bInMap) {
                return map.get(a) - map.get(b);
            } else if (aInMap) {
                return -1;
            } else if (bInMap) {
                return 1;
            } else {
                return a - b;
            }
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }


        return arr1;
    }

    public static void main(String[] args) {
        int []arr1={2,3,1,3,2,4,6,7,9,2,19};
        int []arr2={2,1,4,3,9,6};
        CountSort cs = new CountSort();
        int []res;
        res = cs.relativeSortArray(arr1,arr2);
    }
}
