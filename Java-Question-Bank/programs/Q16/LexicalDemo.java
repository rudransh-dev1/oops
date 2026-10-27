public class LexicalDemo {                 // keywords: public, class | identifier: LexicalDemo
    /* multi-line comment:
       this program shows all lexical elements */
    /** documentation comment for main */
    public static void main(String[] args) {
        // whitespace: spaces, tabs and new lines between tokens
        int      studentAge   =   20;       // extra spaces are ignored
        int _count = 5, $total = 10, marks1 = 85;   // valid identifiers
        double pi = 3.14;                   // floating-point literal
        char grade = 'A';                   // character literal
        String name = "Ravi";               // string literal
        boolean pass = true;                // boolean literal
        int hex = 0x1F, bin = 0b101, big = 1_000_000;   // hex, binary, underscore literals
        String nothing = null;              // null literal
        int[] arr = {1, 2, 3};              // separators: { } [ ] , ;
        System.out.println(name + " " + studentAge + " " + grade + " " + pi + " " + pass);
        System.out.println(_count + " " + $total + " " + marks1);
        System.out.println(hex + " " + bin + " " + big + " " + nothing + " " + arr[0]);
    }
}
