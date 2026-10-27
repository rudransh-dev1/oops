class Person {
    String name;
    Person(String name) { this.name = name; }
    void show() { System.out.println("Name: " + name); }
}
class Student extends Person {
    int marks;
    Student(String name, int marks) {
        super(name);                  // 1. call superclass constructor
        this.marks = marks;
    }
    @Override
    void show() {                     // method overriding
        super.show();                 // 2. call superclass method
        System.out.println("Marks: " + marks);
    }
}
public class SuperDemo {
    public static void main(String[] args) {
        Person p = new Student("Ravi", 85);   // dynamic method dispatch
        p.show();
    }
}
