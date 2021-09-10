import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Design and Implementation of HashSet
 */
public class MyHashSet {

    //Initialize your data structure here.

    //Approach 1: Create a boolean array of size 10^6 and using it to store the occurrence of the key
    //Time: O(N), Space: O(N)
    /*boolean hashset[];

    public MyHashSet() {
        hashset = new boolean[1000001];
    }

    public void add(int key) {
        hashset[key] = true;
    }

    public void remove(int key) {
        hashset[key] = false;
    }

    //Returns true if this set contains the specified element
    public boolean contains(int key) {
        return hashset[key];
    }*/

    //Approach 2: Create an linkedList implementation
    //Time and space complexities are not good.
    private final int MAX_VALUE = 1000000;
    private final int ARRAY_SIZE = 100; //Bucket Size
    //Declare a parent list, bucket list
    private List<List<Integer>> parentList;

    public MyHashSet() {
        //Initialize the bucket with null values
        parentList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parentList.add(null);
        }
    }

    public void add(int key) {
        //Get the hash
        int index = key % ARRAY_SIZE;

        //get the list at the bucket
        List<Integer> childList = parentList.get(index);

        //If it is null, 1st insertion
        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            //Insert only if it doesn't contain the key
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        //Get the hash
        int index = key % ARRAY_SIZE;

        //get the list at the bucket
        List<Integer> childList = parentList.get(index);

        //If childList not null
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }

    //Returns true if this set contains the specified element
    public boolean contains(int key) {
        //Get the hash
        int index = key % ARRAY_SIZE;

        //get the list at the bucket
        List<Integer> childList = parentList.get(index);

        //If childList not null
        if (childList != null) {
            return childList.contains(key);
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
