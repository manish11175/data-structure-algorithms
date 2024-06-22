package data_structure.doubly_linked_list;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList= new DoublyLinkedList<>();
//        doublyLinkedList.addLast(12);
//        doublyLinkedList.addLast(23);
//        doublyLinkedList.addLast(43);
//        doublyLinkedList.insertFirst(90);
//        doublyLinkedList.insertFirst(40);
        doublyLinkedList.display();
        doublyLinkedList.displayReverse();
//        doublyLinkedList.insert(0,187);
//        doublyLinkedList.display();
        doublyLinkedList.insert(0,7551);
//        doublyLinkedList.insert(7,345678);
        doublyLinkedList.display();
//        doublyLinkedList.insert(1,3212);
        doublyLinkedList.display();
        doublyLinkedList.displayReverse();

    }
}
