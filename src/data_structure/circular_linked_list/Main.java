package data_structure.circular_linked_list;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> circularLinkedList= new CircularLinkedList<>();
        circularLinkedList.insertLast(12);
//        circularLinkedList.display();
        circularLinkedList.insertLast(32);
//        circularLinkedList.insertLast(43);
//        circularLinkedList.insertLast(54);
//        circularLinkedList.insertFirst(43);
//        circularLinkedList.insertLast(90);
//        circularLinkedList.insertFirst(92);
//        System.out.println("Head "+circularLinkedList.getHead().val+" Tail "+circularLinkedList.getTail().val);
//        circularLinkedList.display();
//        circularLinkedList.remove(92);
//
//        circularLinkedList.display();
//        System.out.println("Head "+circularLinkedList.getHead().val+" Tail "+circularLinkedList.getTail().val);
//        circularLinkedList.remove(90);
//
//        circularLinkedList.display();
//        System.out.println("Head "+circularLinkedList.getHead().val+" Tail "+circularLinkedList.getTail().val);

        circularLinkedList.remove(12);

        circularLinkedList.display();
        System.out.println("Head "+circularLinkedList.getHead().val+" Tail "+circularLinkedList.getTail().val);
    }
}
