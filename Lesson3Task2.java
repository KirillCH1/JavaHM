
/*

    Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
    Collections.max()

*/



import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        enterNumbers(numbers);
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
        System.out.println("Минимальное число: " + min);
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        System.out.println("Максимальное число: " + max);
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        double average = sum / numbers.size();
        System.out.println("Среднее арифметическое: " + average);
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
