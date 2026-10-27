abstract class Shape {
    abstract double area();                   // abstract method: no body
    void info() { System.out.println("I am a shape"); }   // normal method
}
class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }
}
class Rectangle extends Shape {
    double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
public class AbstractDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();             // ERROR: cannot create object of abstract class
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        s1.info();
        System.out.println("Circle area    = " + s1.area());
        System.out.println("Rectangle area = " + s2.area());
    }
}
