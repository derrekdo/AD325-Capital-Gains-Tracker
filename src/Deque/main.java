package Deque;

import MyUtils.EmptyQueueException;

public class main {
    public static void main(String[] args) throws EmptyQueueException {
        LinkedDeque<Integer> a = new LinkedDeque<>();
        System.out.println(a);
        a.addToFront(1);
        System.out.println(a);
        a.addToFront(1);
        System.out.println(a);
        a.addToFront(2);
        System.out.println(a);
        a.addToBack(5);
        System.out.println(a);
        a.addToBack(4);
        System.out.println(a);

        System.out.println(a.size());
        System.out.println();

        System.out.println("Remove front");
        System.out.println(a.removeFront());
        System.out.println(a);
        System.out.println(a.removeFront());
        System.out.println(a);
        System.out.println("remove back");
        System.out.println(a.removeBack());
        System.out.println(a);
//        System.out.println(a.getFront());
//        System.out.println(a.getBack());
        System.out.println(a.removeBack());
        System.out.println(a);
        System.out.println(a.removeFront());
        System.out.println(a);
        //a.clear();
//        a.addToBack(7);
       // a.display();
    }
}
