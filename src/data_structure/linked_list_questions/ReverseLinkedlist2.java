package data_structure.linked_list_questions;

import data_structure.linked_list.LinkedList;
import data_structure.linked_list.Node;

public class ReverseLinkedlist2 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.printLinkedList();
        int start = 1;
        int end = 6;
        reverseLinkedlist(ll.getHead(),start,end);
        ll.printLinkedList();
    }

    private static void reverseLinkedlist(Node head, int start, int end) {
        Node node = head;
        Node tillStart = head;
        int i=1;
        while (i!=start){
            tillStart=node;
            node = node.getNext();
            i+=1;
        }
        Node startNode=  node;
        Node prev = null;
        while(node!=null && i<=end){
            Node next = node.getNext();
            node.setNext(prev);
            prev=node;
            node=next;
            i+=1;
        }
        tillStart.setNext(prev);
        startNode.setNext(node);
        if(start==1){
            head=prev;
        }
    }


    private static void print(Node node){
        Node temp=node;
        System.out.print("[ Start ");
        while (temp!=null){
            System.out.print(temp.getVal()+"-> ");
            temp=temp.getNext();
        }
        System.out.println("End ]");
    }
}

