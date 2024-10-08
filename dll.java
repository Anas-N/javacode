

import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DoublyLinkedList
{
    private Node head;
    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }
    public void delete(int data)
    {
        if (head == null) return;
        Node current = head;
        while (current != null && current.data != data)
        {
            current = current.next;
        }
        if (current == null) return;
        if (current.prev != null)
        {
            current.prev.next = current.next;
        }
        else
        {
            head = current.next;
        }
        if (current.next != null)
        {
            current.next.prev = current.prev;
        }
    }
    public void display()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
class DLL
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
       
        while (true)
        {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int dataToInsert = scanner.nextInt();
                    dll.insert(dataToInsert);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    int dataToDelete = scanner.nextInt();
                    dll.delete(dataToDelete);
                    break;
                case 3:
                    System.out.println("Doubly Linked List:");
                    dll.display();
                    break;
                case 4:
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}