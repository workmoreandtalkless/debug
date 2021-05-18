package ReviewList;
import java.util.*;
public class TopologicalSort {
    static class GNode {
        public Integer OutDegrees = 0;
        public List<Integer> Parents = new LinkedList<Integer>();
    }


    static class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            if (prerequisites.length == 0)
                return true; // no cycle could be formed in empty graph.

            // course -> list of next courses
            HashMap<Integer, GNode> graph = new HashMap<>();

            // build the graph first
            for (int[] relation : prerequisites) {
                // relation[1] -> relation[0]
                GNode prevCourse = this.getCreateGNode(graph, relation[1]);
                GNode nextCourse = this.getCreateGNode(graph, relation[0]);

                prevCourse.Parents.add(relation[0]);
                nextCourse.OutDegrees += 1;
            }

            // We start from courses that have no prerequisites.
            int totalDeps = prerequisites.length;
            LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
            for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
                GNode node = entry.getValue();
                if (node.OutDegrees == 0)
                    nodepCourses.add(entry.getKey());
            }

            int removedEdges = 0;
            while (nodepCourses.size() > 0) {
                Integer course = nodepCourses.pop();

                for (Integer nextCourse : graph.get(course).Parents) {
                    GNode ParentNode = graph.get(nextCourse);
                    ParentNode.OutDegrees -= 1;
                    removedEdges += 1;
                    if (ParentNode.OutDegrees == 0)
                        nodepCourses.add(nextCourse);
                }
            }

            if (removedEdges != totalDeps)
                // if there are still some edges left, then there exist some cycles
                // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
                return false;
            else
                return true;
        }

        /**
         * Retrieve the existing <key, value> from graph, otherwise create a new one.
         */
        protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
            GNode node = null;
            if (graph.containsKey(course)) {
                node = graph.get(course);
            } else {
                node = new GNode();
                graph.put(course, node);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int [][]nums={{1,0},{0,1}}; //have cycle;
        int [][]nums1 = { {0,1},{1,2},{3,1},{3,4},{2,5},{4,5}};
        sl.canFinish(6,nums);
    }
}
