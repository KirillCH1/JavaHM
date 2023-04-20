
/**
 *
 * Реализовать простой калькулятор (введите первое число, введите второе число, введите требуемую операцию, ответ)
 *
 */

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int number1 = outputNumber();
        System.out.println("Введите второе число: ");
        int number2 = outputNumber();
        int result = Result( number1, number2);
        System.out.printf("Равно: %d", result);

    }
    static int outputNumber() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }

    static int Result(int num1, int num2) {
        System.out.println("Введите оператор: -, +, *, /");
        Scanner scan = new Scanner(System.in);
        String opr = scan.nextLine();
        int result = 0;
        switch (opr) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;

            default:
                System.out.println("Введите оператор: -, +, *, /");
                break;
        }
        return result;

    }

}
