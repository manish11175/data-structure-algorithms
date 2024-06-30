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
         System.out.print("[ Start ");
        while (temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }
         System.out.println("End ]");
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


    public void insertR(T val,int index){
        if(index==0){
            Node newNode= new Node(val,head);
            head=newNode;
            return;
        }
        Node node = head;
        helper(node,val,index,1);
    }

    private void helper(Node node, T val, int index, int i) {
        if(i==index){
            Node newNode = new Node(val,node.next);
            node.next=newNode;
            return;
        }
        if(node==null){
            throw new IndexOutOfBoundsException("Given index is out of range");
        }
        node = node.next;
        i+=1;
        helper(node,val,index,i);
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        LinkedList.size = size;
    }

    public Node getNode(int index) {
        if(index>=size()){
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        while(index!=0){
            node= node.next;
            index-=1;
        }
        return node;
    }
}
