
/*
    Пусть дан произвольный список целых чисел, удалить из него четные числа
*/


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        enterNumbers(numbers);
            // Создаем итератор для списка чисел
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                // Проверяем, является ли число четным
                if (number % 2 == 0) {
                    // Удаляем четное число из списка
                    iterator.remove();
                }
            }

            // Выводим все нечетные числа
            for (Integer number : numbers) {
                System.out.println(number);
            }
        }

    static void enterNumbers(ArrayList<Integer> numbers) {
        System.out.println("Введите числа для заполнения списка");
        System.out.println("Для выхода введите не число ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int output = sc.nextInt();
                numbers.add(output);
            } catch (Exception e) {
                System.out.println("Выход");
                return;
            }
        }
    }
}
