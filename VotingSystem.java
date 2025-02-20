import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> voteMap = new HashMap<>();
        voteMap.put("Alice", 50);
        voteMap.put("Bob", 75);
        voteMap.put("Charlie", 60);

        Map<String, Integer> sortedMap = new TreeMap<>(voteMap);
        System.out.println("Results in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }

        Map<String, Integer> linkedMap = new LinkedHashMap<>(voteMap);
        System.out.println("\nVotes in Insertion Order:");
        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}
