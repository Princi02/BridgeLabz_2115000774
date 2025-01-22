import java.util.*;
public class VolumeOfEarth {
    public static void main(String[] args) {
        int radius = 6378;
        double volumeInKm = (4.0/3) * Math.PI * Math.pow(radius, 3);
        double volumeInMiles = volumeInKm /1.6;
        System.out.println("The volume of earth in cubic kilometers is " + volumeInKm + " and cubic miles is " + volumeInMiles);
    }
}
