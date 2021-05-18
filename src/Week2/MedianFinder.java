package Week2;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> lo; //max heap
    PriorityQueue<Integer> hi; //min heap

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<>();
        hi = new PriorityQueue<>((a,b)-> b-a);
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.peek());
        lo.poll();
        if(lo.size()<hi.size()){
            lo.add(hi.peek());
            hi.poll();
        }
    }

    public double findMedian() {
        return lo.size()>hi.size()? lo.peek():((double)(lo.peek() +hi.peek())*0.5);
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }
}
