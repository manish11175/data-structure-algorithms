package data_structure.linked_list;

import javax.naming.SizeLimitExceededException;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private static int size;
    public LinkedList(){
        this.size=0;
    }

    public void add(T val){
        Node newNode = new Node(val);
        if(head==null){
            head= newNode;
            tail=head;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size+=1;
    }
     public void addBefore(T val){
         Node newNode = new Node(val);
         if(head==null){
             head= newNode;
             tail=head;
         }
         else{
             newNode.next=head;
             head=newNode;
         }
         size+=1;
     }

     public Node getHead(){
        return this.head;
     }

     public Node getTail(){
        return this.tail;
     }

     public void insertLast(T val){
        Node newNode = new Node(val);
        if(tail==null){
            tail= newNode;
            head=tail;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        size+=1;
     }
     public void printLinkedList(){
        Node temp=head;
         System.out.print("[");
        while (temp!=null){
            System.out.print(temp.val+", ");
            temp=temp.next;
        }
         System.out.println("]");
     }

     public void insert(int index,T val){
        if(index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            addBefore(val);
            return;
        }
        if(index==size){
            add(val);
            return;
        }

        int i=1;
        Node temp=head;
        while(i!=index){
            temp=temp.next;
            i+=1;
        }
        Node temp2=temp.next;
        temp.next=new Node(val,temp2);
        size+=1;
     }

    public int size() {
        return size;
    }


    public Node removeFirst(){
        if(head==null){
            throw new NullPointerException();
        }
        Node temp= head;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size-=1;
        return temp;
    }
    public Node removeLast(){
        if(tail==null){
            throw new NullPointerException();
        }
        size-=1;
        Node temp= head;
        if(head.next == null){
            tail=null;
            head=null;
            return temp;
        }

        while(temp.next.next!=null){
            temp=temp.next;
        }

        Node temp2=temp.next;
        temp.next=null;
        tail=temp;
        return temp2;

    }

    public Node remove(int index){
        if(head==null){
            throw new NullPointerException();
        }
        if(size<=index){
            throw new IndexOutOfBoundsException();
        }

        if(index==0){
            return removeFirst();
        }
        int i=1;
        Node temp= head;
        while(i!=index){
            temp=temp.next;
            i+=1;
        }
        size-=1;
        Node temp2=temp.next;
        temp.next=temp2.next;
        return temp2;
    }

}
