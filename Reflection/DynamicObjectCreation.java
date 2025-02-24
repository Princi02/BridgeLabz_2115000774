import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Constructor<Student> constructor = Student.class.getConstructor(String.class, int.class);
        Student student = constructor.newInstance("John", 22);
        System.out.println("Created Student: " + student.getName() + ", Age: " + student.getAge());
    }
}
