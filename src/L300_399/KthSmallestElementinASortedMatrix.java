package L300_399;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> q = new PriorityQueue<>((n1, n2)->n2 -n1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                q.offer(matrix[i][j]);
                if(q.size()>k) q.poll();
            }
        }
        return q.poll();
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        int k=8;
        KthSmallestElementinASortedMatrix kth = new KthSmallestElementinASortedMatrix();
        int x=kth.kthSmallest(matrix,k);
        System.out.println(x);
    }
}
