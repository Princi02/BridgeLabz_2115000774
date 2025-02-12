import java.util.*;

class Student{
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}


class StudentLinkedList{
    private Student head;

    public void addAtBeginning(int rollNumber, String name, int age, String grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        if(head == null){
            head = newStudent;
            return;
        }
        Student temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }


    public void addAtPosition(int rollNumber, String name, int age, String grade, int position){

        if(position <= 1){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for(int i = 1; temp != null && i < position-1; i++){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("Invalid position!");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head, prev = null;
        while(temp != null && temp.rollNumber != rollNumber){
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found.");
            return;
        }
        prev.next = temp.next;
    }



    public void searchByRollNumber(int rollNumber){
        Student temp = head;
        while(temp != null){
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    public void displayRecords() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }


    public void updateGrade(int rollNumber, String newGrade){
        Student temp = head;
        while(temp != null){
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }
}


public class StudentManagement{
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(101, "Alice", 20, "A");
        list.addAtEnd(102, "Bob", 21, "B");
        list.addAtPosition(103, "Charlie", 22, "C", 2);

        System.out.println("Student Records After Adding:");
        list.displayRecords();

        System.out.println("\nSearching for student with Roll No 102:");
        list.searchByRollNumber(102);

        System.out.println("\nUpdating grade for Roll No 101:");
        list.updateGrade(101, "A+");

        System.out.println("\nStudent Records After Grade Update:");
        list.displayRecords();

        System.out.println("\nDeleting student with Roll No 103:");
        list.deleteByRollNumber(103);

        System.out.println("\nFinal Student Records:");
        list.displayRecords();
    }
}