class Employee {                              // superclass
    String name = "Anita";
    double salary = 30000;
    void display() { System.out.println(name + " earns " + salary); }
}
class Manager extends Employee {              // subclass
    double bonus = 5000;
    void total() { System.out.println("Total pay = " + (salary + bonus)); }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display();                          // inherited method
        m.total();                            // own method
    }
}
