package data_structure.linked_list_questions;

import data_structure.linked_list.LinkedList;
import data_structure.linked_list.Node;

public class RemoveDuplicateFromSortedLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll= new LinkedList<>();
        ll.add(1);
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.add(5);
        ll.add(5);
        ll.add(6);
        ll.add(6);
        ll.add(7);
        ll.add(7);
        ll.add(8);
        ll.printLinkedList();
//        removeDuplicate(ll.getHead());
        removeDuplicateR(ll.getHead());
        System.out.println("After removing duplicate");
        ll.printLinkedList();
    }

    public static void removeDuplicate(Node head){
        Node node = head;
        while(node.getNext()!=null){
            if(node.getVal()==node.getNext().getVal()){
                node.setNext(node.getNext().getNext());
            }
            else{
                node=node.getNext();
            }
        }
    }

    public static void removeDuplicateR(Node node){
        if(node.getNext()==null){
            return;
        }

        if(node.getVal()==node.getNext().getVal()){
            node.setNext(node.getNext().getNext());
            removeDuplicateR(node);
        }
        else{
            removeDuplicateR(node.getNext());
        }
    }
}
