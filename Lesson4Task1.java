

/*
    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
*/

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        LinkedList revers =Linked(list);
        System.out.println(revers);
        }
    public static LinkedList Linked (LinkedList list) {
        LinkedList revers = new LinkedList();
        while (!list.isEmpty()) {
            revers.addFirst(list.removeFirst());
        }
        return revers;
    }
}
