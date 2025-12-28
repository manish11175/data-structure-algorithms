package data_structure.heap;

public class Main {
    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap();
        minHeap.add(13);
        minHeap.add(43);
        minHeap.add(32);
        minHeap.add(12);
        minHeap.add(90);
        minHeap.add(2);
        minHeap.display();
        System.out.println( minHeap.remove());
        System.out.println( minHeap.remove());
        System.out.println( minHeap.remove());
        minHeap.display();
    }
}
