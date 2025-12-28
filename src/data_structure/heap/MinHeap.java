package data_structure.heap;


import java.util.ArrayList;
import java.util.List;


public class MinHeap {
    List<Integer> heap;
    int size;

    MinHeap(){
        heap = new ArrayList<>();
        size=0;
    }
    public int parent(int i){
        return i/2;
    }

    public int left(int i){
        return i*2+1;
    }

    public int right(int i){
        return i*2+2;
    }
    public void add(Integer val){
        if(!heap.isEmpty()){
            heap.add(val);
            size+=1;

            int index = size-1;
            upHeap(index);
        }
        else {
            heap.add(val);
            size+=1;
        }
    }

    public int remove() throws Exception{
        if(heap.isEmpty()){
            throw new Exception("Heap is empty");
        }

        int temp = heap.get(0);
        int last = heap.remove(size-1);
        size-=1;
        heap.set(0,last);
        downHeap(0);
        return temp;
    }
    private void downHeap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);
        if(left<size && heap.get(min)>heap.get(left)){
            min=left;
        }
        if(right<size && heap.get(min)>heap.get(right)){
            min=right;
        }

        if(min!=index){
            swap(heap,min,index);
            downHeap(min);
        }
    }
    public void upHeap(int index){

        while(index>0 && heap.get(index)<heap.get(parent(index))){
            swap(heap,index,index/2);
            index/=2;
        }
    }
    public  int peek(){
         return heap.isEmpty()?-1:heap.get(0);
    }

    public void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    public void display(){
        System.out.println(heap);
    }
}
