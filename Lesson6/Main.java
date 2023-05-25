
/*
       Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
       Реализовать в java.
       Создать множество ноутбуков.
       Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
       отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру,
       соответствующую необходимому критерию:
       1 - ОЗУ
       2 - Объем ЖД
       3 - Операционная система
       4 - Цвет …
       Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно
       также в Map. Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.

*/


import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<List> parameters = creator();
        List<Laptop> lap1 = lapGenerator(20, parameters);
        Laptop lap2 = filter(parameters);
        List<Laptop> suitable = new ArrayList<>();
        for (int i = 0; i < lap1.size() ; i ++ ){
            if(lap2.equals(lap1.get(i))) {
                suitable.add(lap1.get(i));

            }
        }
        if(!(suitable == null))
            for (int i = 0; i < suitable.size() ; i ++ ){
                suitable.get(i).printDescription();
            }
        else
            System.out.println("Подходящих вариантов нет");
        System.out.println("************************************************");
        for (int i = 0; i < lap1.size() ; i ++ ){
            lap1.get(i).printDescription();
            System.out.println("************************************************");
        }


    }
    static List<Laptop> lapGenerator(int count , List<List> parameters){
        List<Laptop> list = new ArrayList<>();
        for (int i = 0; i < count ; i ++){
            list.add(ranLap( parameters));
        }
        return list;
    }
    static Laptop ranLap(List<List> parameters){
        Random random = new Random();
        Laptop lap = new Laptop(
                (String)  parameters.get(0).get(random.nextInt(parameters.get(0).size())),
                (Integer) parameters.get(1).get(random.nextInt(parameters.get(1).size())),
                (Integer) parameters.get(2).get(random.nextInt(parameters.get(2).size())),
                (String) parameters.get(3).get(random.nextInt(parameters.get(3).size())),
                (String) parameters.get(4).get(random.nextInt(parameters.get(4).size())));
        return  lap;

    }
    static List<List> creator (){

        List<String> brand = new ArrayList<>(Arrays.asList("HUAWEI", "MSI" , "ASUS", "SAMSUNG","LENOVO"));
        List<Integer> ram = new ArrayList<>(Arrays.asList(4,6,8,12,16,32));
        List<Integer> hdd = new ArrayList<>(Arrays.asList(256,512,1024,2048));
        List<String> os = new ArrayList<>(Arrays.asList("Windows", "Linux" , "Нет"));
        List<String> colors = new ArrayList<>(Arrays.asList("Серый", "Серебристый" , "Черный", "Красный","Белый"));
        List<List> parameters = new ArrayList<>(Arrays.asList( brand,ram,hdd,os,colors));
        return parameters;
    }
    static Laptop filter(List<List> parameters){
        Scanner scanner = new Scanner(System.in);
        String brand = "";
        String os = "";
        String color = "";
        int ram = 0;
        int hdd = 0;

        System.out.println("Выберите производителя:");
        for (int i = 0; i < parameters.get(0).size(); i ++ ) {
            System.out.println((i) + ". " + parameters.get(0).get(i));
        }
        int input;
        System.out.println((parameters.get(0).size()) + ". Чтобы пропустить");
        try {
            while (!scanner.hasNextInt() || (input = scanner.nextInt()) >= parameters.get(0).size() + 1) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
                scanner.nextLine();
            }
            if(!(input == parameters.get(0).size()))
                brand = (String) parameters.get(0).get(input );
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }
        //*************************************************************************************************
        System.out.println("Выберите объем ОЗУ (ГБ):");
        for (int i = 0; i < parameters.get(1).size(); i ++ ) {
            System.out.println((i) + ". " + parameters.get(1).get(i));
        }
        System.out.println((parameters.get(1).size()) + ". Чтобы пропустить");
        try {
            while (!scanner.hasNextInt() || (input = scanner.nextInt()) > parameters.get(1).size() + 1) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
                scanner.nextLine();
            }
            if(!(input == parameters.get(1).size()))
                ram = (Integer) parameters.get(1).get(input );
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }
        //*************************************************************************************************
        System.out.println("Выберите объем жесткого диска (ГБ):");
        for (int i = 0; i < parameters.get(2).size(); i ++ ) {
            System.out.println((i) + ". " + parameters.get(2).get(i));
        }
        System.out.println((parameters.get(2).size()) + ". Чтобы пропустить");
        try {
            while (!scanner.hasNextInt() || (input = scanner.nextInt()) > parameters.get(2).size()+1) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
                scanner.nextLine();
            }
            if(!(input == parameters.get(2).size()))
                hdd = (Integer) parameters.get(2).get(input);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }
        //*************************************************************************************************
        System.out.println("Выберите операционную систему:");
        for (int i = 0; i < parameters.get(3).size(); i ++ ) {
            System.out.println((i) + ". " + parameters.get(3).get(i));
        }
        System.out.println((parameters.get(3).size()) + ". Чтобы пропустить");
        try {
            while (!scanner.hasNextInt() || (input = scanner.nextInt()) > parameters.get(3).size()+1) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
                scanner.nextLine();
            }
            if(!(input == parameters.get(3).size()))
                os = (String) parameters.get(3).get(input);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }
        //*************************************************************************************************
        System.out.println("Выберите цвет:");
        for (int i = 0; i < parameters.get(4).size(); i ++ ) {
            System.out.println((i) + ". " + parameters.get(4).get(i));
        }
        System.out.println((parameters.get(4).size()) + ". Чтобы пропустить");
        try {
            while (!scanner.hasNextInt() || (input = scanner.nextInt()) > parameters.get(4).size()+1) {
                System.out.println("Некорректный ввод. Попробуйте снова:");
                scanner.nextLine();
            }
            if(!(input == parameters.get(4).size()))
                color = (String) parameters.get(4).get(input);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }

        Laptop laptop = new Laptop( brand,ram,hdd,os,color);

        scanner.close();
        return laptop;
    }

}
