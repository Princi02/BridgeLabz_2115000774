public class DividePens {
    public static void main(String[] args) {
        int totalPens = 14;
        int totalStudents = 3;
        int penPerStudent = totalPens / totalStudents;
        int remainingPens = totalPens % totalStudents;
        System.out.println("The Pen Per Student is " + penPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}
