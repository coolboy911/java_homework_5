package homework.homework_java_4;

import java.util.HashMap;

/* 
 * Подсчитать количество искомого слова, через map 
 * (наполнением значение, где искомое слово будет являться ключом), вносить все слова не нужно
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 * Запрос: Россия
 * Ответ: Россия - 2
 * toLoverCase().
 * (Усложнение - игнорировать пунктуацию)*
*/
public class task1 {
    public static void main(String[] args) {
        String str = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String keyWords = "Россия  планеты";
        System.out.println(CountWords(str, keyWords));
    }
    public static HashMap<String, Integer> CountWords(String str, String keyWords) {
        HashMap<String,Integer> map = new HashMap<>();
        str = str.replaceAll("[.,?!:'\"]", " ").toLowerCase();
        keyWords = keyWords.replaceAll("[.,?!:'\"]", " ").toLowerCase();
        String[] arr = str.split("\\s+");  // "\\s+" split all spaces
        String[] keyArr = keyWords.split("\\s+");

        for (String key : keyArr) {
            map.put(key, 0);
        }
        for (String word : arr) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
        }
        return map;
    }
}
