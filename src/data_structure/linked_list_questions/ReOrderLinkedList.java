package data_structure.linked_list_questions;

import data_structure.linked_list.LinkedList;
import data_structure.linked_list.Node;

//1->2->3->4->5  1->5->2->4->3
//1->2->3->4->5->6   1->6->2->5->3->4
public class ReOrderLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer>ll= new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.printLinkedList();
        reorder(ll.getHead());
        ll.printLinkedList();
    }

    public static void reorder(Node head){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }

        Node middle = slow;

        Node prev = null;
        while(slow!=null){
            Node next = slow.getNext();
            slow.setNext(prev);
            prev=slow;
            slow=next;
        }

        Node node = head;
        Node last = head;


        while(node!=middle){
            Node next = node.getNext();
            Node reverseNext = prev.getNext();
            if(node==head){
                node.setNext(prev);
            }
            else {
                node.setNext(prev);
                last.setNext(node);
            }
            last=prev;
            node = next;
            prev = reverseNext;
        }
    }
}
