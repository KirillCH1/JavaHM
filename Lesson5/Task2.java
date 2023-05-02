

/*
    Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
    Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
    Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу,
    которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
    Для сортировки использовать TreeMap.
*/


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов", "Иван Иванов", "Светлана Петрова",
                "Иван Иванов", "Анна Мусина", "Мария Федорова", "Мария Савина",
                "Марина Лугова", "Иван Мечников", "Анна Крутова", "Мария Рыкова"
        );
        HashMap<String, Integer> nameQuantity = new HashMap<>();
        for (String employee : employees){
            String name =  removeLastName(employee);
            if(nameQuantity.containsKey(name)){
                int i = nameQuantity.get(name);
                nameQuantity.put(name, i+1);
            }else {
                nameQuantity.put(name,1);
            }
        }
        Map<String, Integer> map = new TreeMap<String, Integer>();
        nameQuantity = sort(nameQuantity);
        System.out.println(nameQuantity);
    }
    static String removeLastName(String name){
        String[] str = name.split(" ");
        return str[0];
    }
    public static HashMap<String, Integer> sort(HashMap<String, Integer> hashMap) {
        
        Comparator<String> valueComparator = (s1, s2) -> {
            int compareResult = hashMap.get(s1).compareTo(hashMap.get(s2));
            if (compareResult == 0) {
                return s1.compareTo(s2);
            }
            return compareResult;
        };
        TreeMap<String, Integer> sortedTreeMap = new TreeMap<>(valueComparator.reversed());
        sortedTreeMap.putAll(hashMap);
        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedTreeMap.entrySet()) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        return sortedHashMap;
    }

}
