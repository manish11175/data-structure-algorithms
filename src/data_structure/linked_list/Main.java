package data_structure.linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer>linkedList= new LinkedList<>();
        linkedList.add(12);
        linkedList.add(34);
        linkedList.add(34);
        linkedList.add(54);
        linkedList.add(45);
        linkedList.printLinkedList();
        linkedList.addBefore(90);
        linkedList.addBefore(78);
        linkedList.printLinkedList();
        linkedList.insert(5,100);
        linkedList.insert(0,100);
        linkedList.printLinkedList();
        System.out.println(linkedList.size());
        linkedList.insert(9,1000);
        linkedList.printLinkedList();
        linkedList.removeFirst();

        linkedList.printLinkedList();
        linkedList.removeLast();
        linkedList.printLinkedList();

        System.out.println(linkedList.size());
        linkedList.remove(7);
        linkedList.printLinkedList();
        linkedList.remove(0);
        linkedList.printLinkedList();
        linkedList.remove(3);
        linkedList.printLinkedList();

        linkedList.insertR(1,0);
        linkedList.insertR(342,3);
        linkedList.printLinkedList();
        System.out.println("Head "+linkedList.getHead().val);
        System.out.println("Tail "+linkedList.getTail().val);


    }
}
