
// Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
// Используйте StringBuilder для подготовки ответа
// Исходная json строка это просто String !!! Для работы используйте методы String, такие как replace, split, substring и т.д. по необходимости
// Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл.



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args)  {

        Logger logger = Logger.getAnonymousLogger();
        File file = new File("sasdrc/students.json");
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("src/log.txt");
        }catch (IOException e){
            e.printStackTrace();
            logger.log(Level.WARNING ,e.getMessage());
        }
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            String strArr = sc.nextLine();
            //char[] arr = sc.nextLine().toCharArray();
            String[] student = unpackData(strArr);
            printArray(student);
            saveToFile(student , true);

        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.INFO ,e.getMessage());
        }
        fileHandler.close();
    }

    static int arraySize(char[] arr) {
        int size = 0;
        for (char c : arr) {
            if (c == ':') {
                size++;
            }
        }
        return size;
    }

    static String[] unpackData(char[] arr) {
        int size = arraySize(arr);
        String[] studentsData = new String[size];
        int temp = 0;
        int start = 0;
        int end ;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == ':'){
                start = i+2;
            }
            if(arr[i] == ',' | i == (arr.length - 2)){
                if(arr[i-1] == '}'){
                    end = i-2;
                }
                else {
                    end = i-1;
                }
                StringBuilder sb = new StringBuilder();
                for (int f = start; f < end ; f++){
                    sb.append(arr[f]);
                }
                studentsData[temp] = sb.toString();
                temp++;
            }
        }
        return studentsData;
    }

    static String[] unpackData(String str){
        String[] signs;
        signs = new String[] {"[","]"," ","{", "}","\":",";",",","\"фамилия\"","\"оценка\"","\"предмет\""};
        for (int i = 0 ; i < signs.length ; i ++){
            str = str.replace(signs[i], "");
        }
        String[] arr = str.split("\"");
        System.out.println(str);
        return arr;
    }

    static void saveToFile(String[] str, boolean a )  {
        String path = "src/data.txt";
        String s = printArray(str);
        try (FileWriter printWriter = new FileWriter(path , a)) {
            printWriter.write(s);
            printWriter.flush();
        }catch (Exception e ) {
           e.printStackTrace();
        }
    }

    static String printArray(String[] str){
        String s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < str.length ; i += 3 ){
            sb.append("Студент "+ str[i] + " получил " + str[i+1] + " предмету "+ str[i+2] + "\n" );
        }
        s = sb.toString();
        System.out.println(s);
        return s;
    }

}
