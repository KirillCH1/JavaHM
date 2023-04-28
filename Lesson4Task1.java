
/*
    Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
*/


import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList revers =Linked(list);
        System.out.println(revers);
        }
    public static LinkedList Linked (LinkedList list) {
        LinkedList reversedList = new LinkedList();
        while (!list.isEmpty()) {
            reversedList.addFirst(list.removeFirst());
        }
        return reversedList;
    }
}
