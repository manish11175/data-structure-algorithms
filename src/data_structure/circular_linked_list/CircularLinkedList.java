package data_structure.circular_linked_list;

public class CircularLinkedList <T>{
    private Node head;
    private Node tail;
    private int size;

    CircularLinkedList(){
        this.size=0;
    }


    public void insertLast(T val){
        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
            tail.next=head;
        }
        else{
            node.next=head;
            tail.next=node;
            tail=node;
        }
        size+=1;
    }

    public void insertFirst(T val){
        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
            tail.next=head;
        }
        else{
            node.next=head;
            tail.next=node;
            head=node;
        }
        size+=1;
    }
    public void display(){
        System.out.print("[Start ");
        Node node=head;
        while(node.next!=head){
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        if(node!=null){
            System.out.print(node.val+" -> ");
        }
        System.out.println(" End]");
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void remove(T val){
        Node node = head;
        if(node==null){
            throw new NullPointerException();
        }
        if(node.val==val){
            head=head.next;
            tail.next=head;
            size-=1;
        }
        else{
            while(node.next!=head){
                if(node.next.val==val){
                    node.next=node.next.next;
                    if(node.next==head){
                        tail=node;
                    }
                    size-=1;
                    return;
                }
                node=node.next;
            }
        }
    }
}
