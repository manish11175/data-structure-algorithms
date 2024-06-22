package data_structure.doubly_linked_list;

public class DoublyLinkedList <T>{

    private Node head;
    private Node tail;
    private static int size;
    DoublyLinkedList(){
        this.size=0;
    }


    public void insertFirst(T val){

        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        size+=1;
    }

    public void addLast(T val){
        Node node = new Node(val);
        if(head==null){
            head=node;
        }
        else{
            tail.next=node;
            node.prev=tail;
        }
        tail=node;
        size+=1;
    }

    public void display(){
        System.out.print("[ Start ");
        Node node = head;
        while(node!=null){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.println("End ]");
    }

    public void displayReverse(){
        System.out.print("[ End ");
        Node node = tail;
        while(node!=null){
            System.out.print(node.val+" -> ");
            node=node.prev;
        }
        System.out.println("Start ]");
    }


    public void insert(int index,T val){
        if(index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            insertFirst(val);
        }
        else if(index==size){
            addLast(val);
        }
        else{
            int i=1;
            Node node = head;
            while(i!=index){
                node=node.next;
                i+=1;
            }
            Node newNode = new Node(val,node.next,node);
            node.next.prev=newNode;//
            node.next=newNode;

            // if node.next!=null  -> newNode.next.prev = newNode;

            size+=1;
        }
    }
}
