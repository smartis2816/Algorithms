package Seminar3;

public class myDList {
    Node Head, Tail;
    private class Node{
        int value;
        Node next;
        Node prew;
    }

    public void pushFront(int value){
        Node node = new Node();
        node.value = value;

        if(Head == null){
            Tail = node;
        }else{
            if(Head.next == null){
                Head.next = Tail;
                Tail.prew = Head;
            }else{
                node.next = Head;
                Head.prew = node;

            }
        }
        Head = node;
    }

    public void print(){
        Node current = Head;
        while(current != null){
            System.out.printf("%d ", current.value);
            current = current.next;
        }
    }
}