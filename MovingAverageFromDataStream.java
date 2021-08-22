import java.util.LinkedList;
import java.util.Queue;

/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
Time: 97.80 percentile Space: O(size)
 */

public class MovingAverageFromDataStream {

    Queue<Integer> que;
    int maxSize;
    double sum;

    public MovingAverageFromDataStream(int size) {
        que = new LinkedList<>();
        maxSize = size;
        sum = 0;
    }

    public double next(int val) {
        //Enqueue the value
        que.offer(val);
        sum += val;

        //If the size of the queue exceeds max size Dequeue
        if (que.size() > maxSize) {
            sum -= que.poll();
        }

        return sum / que.size();
    }

    public static void main(String[] args) {
        MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);
        System.out.println(m.next(1)); // return 1.00000
        System.out.println(m.next(10)); // return 5.50000
        System.out.println(m.next(3)); // return 4.66667
        System.out.println(m.next(5)); // return 6.00000
    }
}
