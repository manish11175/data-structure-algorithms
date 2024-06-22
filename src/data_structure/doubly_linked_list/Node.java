package data_structure.doubly_linked_list;

public class Node {
    Object val;
    Node next;
    Node prev;

    Node(Object val){
        this.val=val;
    }

    Node(Object val,Node next,Node prev){
        this.val=val;
        this.next=next;
        this.prev=prev;
    }
}
