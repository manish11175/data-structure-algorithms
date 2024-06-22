package data_structure.linked_list;

public class Node {
    Object val;
    Node next;

    public Node(Object val) {
        this.val=val;
    }

    public Node(Object val,Node node) {
        this.val=val;
        this.next=node;
    }

    public Node(){

    }

}
