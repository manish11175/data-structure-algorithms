package data_structure.linked_list_questions;

import data_structure.linked_list.LinkedList;
import data_structure.linked_list.Node;

public class CyclicLL {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        Node nodeAt3=ll.getNode(3);
        System.out.println("Node at 3 index has value = "+nodeAt3.getVal());
        ll.getTail().setNext(nodeAt3);
        System.out.println(hasCycle(ll.getHead()));
        System.out.println(lengthOfCycle(ll.getHead()));
        System.out.println("Start of the cycle "+startOfCycle(ll.getHead()).getVal());
    }

    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.getNext() !=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static int lengthOfCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.getNext() !=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
            if(slow==fast){
                Node temp = slow;
                int count = 0;
                do {
                    temp=temp.getNext();
                    count+=1;
                }
                while (temp!=slow);
                return count;
            }
        }
        return -1;
    }

    public static Node startOfCycle(Node head){
        int l = lengthOfCycle(head);
        if(l==-1){
            throw new RuntimeException("Cycle is not detected");
        }
        Node first = head;
        Node second = head;
        while(l!=0){
            second=second.getNext();
            l-=1;
        }

        do {
            second=second.getNext();
            first=first.getNext();
        }
        while (first!=second);
        return first;
    }
}
