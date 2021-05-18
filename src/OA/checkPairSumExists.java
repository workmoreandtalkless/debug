package OA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class checkPairSumExists {
    public boolean  checkPairSumExists(int rows, int cols,int[][]arr,int sum){
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(set.contains(sum-arr[i][j])){
                    return true;
                }
                else {
                    set.add(sum);
                }
            }
        }
        return false;
    }


}
