package data_structure.circular_linked_list;

public class Node {
    Object val;
    public Node next;
    Node(Object val){
        this.val=val;
    }

    Node(Object val,Node next){
        this.val=val;
        this.next=next;
    }
}
