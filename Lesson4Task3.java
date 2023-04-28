
/*
    Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
*/

import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static int sumLinkedList(LinkedList<Integer> list) {
        int sum = 0;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            sum += element;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(sumLinkedList(list)); // выведет: 15
    }
}
