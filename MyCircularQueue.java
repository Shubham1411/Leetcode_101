/*
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations
are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position
to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal
queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language.
 */

//Time Complexity: O(1) for each operation. 98 percentile. Space:O(n)
public class MyCircularQueue {

    int queue[];
    int front, rear, size;

    //Initialize the class variables where k=size of the queue
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = -1;
        rear = -1;
    }

    //Insert an element into the circular queue. Return true if the operation is successful
    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            queue[++rear] = value;
            front = rear;
            return true;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        return true;
    }

    //Delete an element from the circular queue. Return true if the operation is successful
    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
        return true;
    }

    //Returns the front item in the queue
    public int Front() {
        if (isEmpty())
            return -1;
        else
            return queue[front];
    }

    //Returns the last item in the queue
    public int Rear() {
        if (isEmpty())
            return -1;
        else
            return queue[rear];
    }

    //Checks if the queue is empty
    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        else
            return false;
    }

    //Checks if the queue is full
    public boolean isFull() {
        if (front == (rear + 1) % queue.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}
