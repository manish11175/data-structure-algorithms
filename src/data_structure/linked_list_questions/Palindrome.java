package data_structure.linked_list_questions;

import data_structure.linked_list.LinkedList;
import data_structure.linked_list.Node;

public class Palindrome {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        System.out.println(isPalindrome(ll.getHead()));
    }

    public static boolean isPalindrome(Node head){
        boolean isPalindrome = true;
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }

        Node middle = slow;
        //Reverse of half linked list
        Node prev = null;
        while (slow!=null){
            Node next = slow.getNext();
            slow.setNext(prev);
            prev=slow;
            slow=next;
        }
        LinkedList.print(head);
        LinkedList.print(prev);
        Node node = head;
        while(node!=middle){
            if(node.getVal()!=prev.getVal()){
                return false;
            }
            node =  node.getNext();
            prev = prev.getNext();
        }
        return isPalindrome;
    }
}
