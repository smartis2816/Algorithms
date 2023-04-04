package HW4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int count = 0;
        Random r = new Random();
        while (count <= 30){
            tree.add(r.nextInt(1, 11));
            count++;
        }
    }
}
