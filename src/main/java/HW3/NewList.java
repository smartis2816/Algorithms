package HW3;

public class NewList {
    Node head;
    Node tail;

    private class Node {
        int value;
        Node next;
        Node prev;

    }

    // Это метод разворота списка, который требовался по ДЗ
    public void reverseList() {
        if (head == null || head.next == null)
            return;
        Node temp = head;
        head = tail;
        tail = temp;
        Node current = head;
        while (current != null) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.next;
        }
    }

    public void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if (tail != null) {
            node.prev = tail;
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.printf("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }
}
