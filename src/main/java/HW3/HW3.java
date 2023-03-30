package HW3;

public class HW3 {
    public static void main(String[] args) {
        NewList nodes = fillList();
        nodes.print();
        nodes.reverseList();
        nodes.print();
    }

    public static NewList fillList() {
        NewList nodes = new NewList();
        for (int i = 1; i <= 5; i++)
            nodes.pushBack(i);
        return nodes;
    }

}
