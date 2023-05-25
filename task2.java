package homework.homework_java_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

// Пусть дан список сотрудников:

// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.
public class task2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Иван Иванов");
        list.add("Светлана Петрова");
        list.add("Кристина Белова");
        list.add("Анна Мусина");
        list.add("Анна Крутова");
        list.add("Иван Юрин");
        list.add("Петр Лыков");
        list.add("Павел Чернов");
        list.add("Петр Чернышов");
        list.add("Мария Федорова");
        list.add("Марина Светлова");
        list.add("Мария Савина");
        list.add("Мария Рыкова");
        list.add("Марина Лугова");
        list.add("Анна Владимирова");
        list.add("Иван Мечников");
        list.add("Петр Петин");
        list.add("Иван Ежов");

        SortNames(list);
    }
    public static void SortNames(ArrayList<String> list) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : list) {
            String name = string.split(" ")[0];
            Integer count = map.containsKey(name) ? map.get(name) : 0;  // если есть оставляем число, если нет то ноль
            map.put(name, count + 1);
            
        }
        
        ArrayList<Integer> sort = new ArrayList<>(map.values());
        for (int i = 0; i < sort.size() - 1; i++) {
            for (int j = i + 1; j < sort.size(); j++) {
                if (sort.get(i) < sort.get(j)) {
                    Integer temp = sort.get(i);
                    sort.set(i, sort.get(j));
                    sort.set(j, temp);
                }
            }
        }
        // System.out.println(sort);
        for (int i = 0; i < sort.size() - 1; i++) {
            if (sort.get(i).equals(sort.get(i + 1))) {
                sort.remove(i);
                i--;
            }
        }
        // System.out.println(sort);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>(map.size());
        for (Integer integer : sort) {
            for (var item : map.entrySet()) {
                if (item.getValue().equals(integer)) sortedMap.put(item.getKey(), integer);
            }
        }
        System.out.println(sortedMap);
    }
}
