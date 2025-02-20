package ListInterface;
import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> map = getFrequencyMap(fruits);
        System.out.println(map);
    }
    

    public static Map<String, Integer> getFrequencyMap(List<String> list){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String str : list){
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0)+1);
        }
        return frequencyMap;
    }
}
