public class PrecedenceDemo {
    public static void main(String[] args) {
        System.out.println(10 + 5 * 2);        // 20 : * before +
        System.out.println((10 + 5) * 2);      // 30 : () overrides
        System.out.println(100 / 10 * 2);      // 20 : / and * same level, left to right
        System.out.println(2 + 3 > 4 && 1 < 2);// true : arithmetic > relational > logical
        int a, b, c;
        a = b = c = 5;                         // right to left assignment
        System.out.println(a + " " + b + " " + c);
        int x = 2;
        int y = x++ + ++x * 2;                 // 2 + (4*2) = 10
        System.out.println(y + " " + x);
        System.out.println(true ? 1 : false ? 2 : 3);   // ternary: right to left
        System.out.println(2 + 3 + "A" + 2 + 3);        // 5A23 : left to right
    }
}
