class Parent {
    final void rules() { System.out.println("Final method: cannot be overridden"); }
}
class Child extends Parent {
    // void rules() { }   // ERROR: cannot override final method
}
final class Constants {                       // final class: cannot be extended
    static final double PI = 3.14159;         // final variable: constant
}
// class Sub extends Constants { }            // ERROR: cannot inherit from final class

public class FinalDemo {
    public static void main(String[] args) {
        final int MAX = 100;                  // final variable
        // MAX = 200;                         // ERROR: cannot assign a value to final variable
        System.out.println("MAX = " + MAX);
        System.out.println("PI  = " + Constants.PI);
        new Child().rules();
    }
}
