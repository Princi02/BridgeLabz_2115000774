package Level1PracticeQuestions;
public class Person {
    String name;
    int age;

    // default constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    // copy constructor
    public Person(Person p){
        this.name = p.name;
        this.age = p.age;
    }

    public void display(){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }


    public static void main(String[] args) {
        Person p1 = new Person("Priyanshi", 21);
        Person p2 = new Person(p1);
        p2.display();
    }
}
