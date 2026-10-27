class Calculator {
    int add(int a, int b)            { return a + b; }          // 2 int
    int add(int a, int b, int c)     { return a + b + c; }      // 3 int  (number differs)
    double add(double a, double b)   { return a + b; }          // 2 double (type differs)
    String add(String a, String b)   { return a + b; }          // 2 String (type differs)
}
public class OverloadDemo {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
        System.out.println(c.add(1.5, 2.5));
        System.out.println(c.add("Java", "Programming"));
    }
}
