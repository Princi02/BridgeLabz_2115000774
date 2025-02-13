import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourWithQueue {
    
    public static int findStartingPoint(PetrolPump[] pumps) {
        int totalSurplus = 0, currentSurplus = 0;
        Queue<Integer> queue = new LinkedList<>();
        int startIndex = 0;

        for (int i = 0; i < pumps.length; i++) {
            int netGain = pumps[i].petrol - pumps[i].distance;
            totalSurplus += netGain;
            currentSurplus += netGain;
            queue.add(i);

            while (currentSurplus < 0 && !queue.isEmpty()) {
                int removedPump = queue.poll();
                currentSurplus -= pumps[removedPump].petrol - pumps[removedPump].distance;
                startIndex = removedPump + 1;
            }
        }

        return (totalSurplus >= 0) ? startIndex : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int start = findStartingPoint(pumps);
        System.out.println(start == -1 ? "No valid starting point" : "Start at petrol pump index: " + start);
    }
}
