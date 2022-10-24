package Deque;

import MyUtils.EmptyQueueException;

public class main {
    public static void main(String[] args) throws EmptyQueueException {
        LinkedDeque<Integer> a = new LinkedDeque<>();
        a.addToFront(1);
        a.display();
        a.addToFront(1);
        a.display();
        a.addToFront(2);
        a.display();
        a.addToBack(5);
        a.display();
        a.addToBack(4);
        a.display();

        System.out.println(a.size());
        System.out.println();

        System.out.println("Remove front");
        System.out.println(a.removeFront());
        a.display();
        System.out.println(a.removeFront());
        a.display();
        System.out.println("remove back");
        System.out.println(a.removeBack());
        a.display();
//        System.out.println(a.getFront());
//        System.out.println(a.getBack());
        System.out.println(a.removeBack());
        a.display();
        a.clear();
//        a.addToBack(7);
       // a.display();
    }
}
