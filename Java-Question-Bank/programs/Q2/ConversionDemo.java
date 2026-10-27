public class ConversionDemo {
    public static void main(String[] args) {
        // A. Automatic type conversion (widening)
        int i = 100;
        long l = i;            // int -> long
        float f = l;           // long -> float
        double d = f;          // float -> double
        System.out.println("Widening : " + i + " -> " + l + " -> " + f + " -> " + d);

        // B. Type casting (narrowing, manual)
        double x = 9.99;
        int y = (int) x;                       // truncated, not rounded
        int big = 300;
        byte b = (byte) big;                   // 300 - 256 = 44
        System.out.println("(int) 9.99 = " + y + ", (byte) 300 = " + b);

        // C. char and int
        char c = 'A';
        int code = c;                          // conversion: char -> int
        char next = (char) (c + 1);            // casting: int -> char
        System.out.println("char 'A' -> int " + code + ", cast back -> '" + next + "'");

        // D. Automatic type promotion in expressions
        byte p = 50, q = 20;
        int r = p * q;                         // byte * byte promoted to int
        System.out.println("byte*byte promoted to int = " + r);
        System.out.println("7 / 2 = " + (7 / 2) + ", (double) 7 / 2 = " + ((double) 7 / 2));
    }
}
