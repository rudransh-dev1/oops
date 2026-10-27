public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 3;
        // Arithmetic
        System.out.println("a+b=" + (a+b) + " a-b=" + (a-b) + " a*b=" + (a*b) + " a/b=" + (a/b) + " a%b=" + (a%b));
        // Unary
        int x = 5;
        System.out.println("x++=" + (x++) + " x=" + x + " ++x=" + (++x) + " -x=" + (-x));
        // Relational
        System.out.println("a>b " + (a>b) + ", a==b " + (a==b) + ", a!=b " + (a!=b));
        // Logical + short circuit
        System.out.println("&&: " + (a>5 && b<5) + "  ||: " + (a<5 || b<5) + "  !: " + !(a>5));
        // Assignment
        int c = 5; c += 3; c *= 2;
        System.out.println("c=" + c);
        // Bitwise (5=0101, 3=0011)
        System.out.println("5&3=" + (5&3) + " 5|3=" + (5|3) + " 5^3=" + (5^3) + " ~5=" + (~5));
        // Shift
        System.out.println("8<<2=" + (8<<2) + " 8>>2=" + (8>>2) + " -8>>>28=" + (-8>>>28));
        // Ternary
        int max = (a > b) ? a : b;
        System.out.println("max=" + max);
        // instanceof
        String s = "hi";
        System.out.println("s instanceof String: " + (s instanceof String));
    }
}
