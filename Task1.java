
/**
 *
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n)
 *
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите число: ");
        int i = sc.nextInt();
        System.out.printf("Равно: %d\n", giveMeNumber(i));
        sc.close();
    }

    public static int giveMeNumber(int a) {
        return (a * (a + 1)) / 2;
    }
}
