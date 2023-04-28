
/*
    Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.
*/

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("Первый");
        queue.enqueue("Второй");
        queue.enqueue("Третий");
        queue.enqueue("Четвертый");
        queue.enqueue("Пятый");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.first());
    }
}


import java.util.LinkedList;

public class Queue {
    LinkedList list = new LinkedList();

    void enqueue( String element) {
        list.addLast(element);
    }
    String dequeue() {
        return (String) list.pollFirst();
    }

    String first() {
        return (String) list.peekFirst();
    }
}

