/* Abstraction, Encapsulation, Inheritance, Polymorphism in one program */
abstract class Shape {                           // ABSTRACTION: only WHAT, not HOW
    abstract double area();
}
class Circle extends Shape {                     // INHERITANCE: Circle IS-A Shape
    private double r;                            // ENCAPSULATION: data hidden
    Circle(double r) { this.r = r; }
    public double getR() { return r; }           // controlled access via getter
    public void setR(double r) { if (r > 0) this.r = r; }
    double area() { return 3.14159 * r * r; }    // POLYMORPHISM: overriding
}
class Rectangle extends Shape {
    private double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
public class OOPPrinciplesDemo {
    static int add(int a, int b) { return a + b; }            // overloading
    static double add(double a, double b) { return a + b; }   // (compile-time polymorphism)
    public static void main(String[] args) {
        Shape s1 = new Circle(5), s2 = new Rectangle(4, 6);
        System.out.println("Circle area    = " + s1.area());   // runtime polymorphism
        System.out.println("Rectangle area = " + s2.area());
        System.out.println(add(2, 3) + " " + add(2.5, 3.5));
    }
}
