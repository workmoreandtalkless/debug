package L200_299;

import Pramp.MeetingPlanner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // Add the first meeting
        allocator.add(intervals[0][1]);

        //Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            //If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            //If a new room is to be assigned, then also we add to the heap,
            //If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII mr= new MeetingRoomsII();
        int [][]intervals = {
                {0, 30},{5, 10},{15, 20}
        };
        int x=mr.minMeetingRooms(intervals);
        System.out.print(x);
    }

}
