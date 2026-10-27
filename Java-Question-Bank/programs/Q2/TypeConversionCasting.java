// Q1b, Dec 2024/Jan 2025 & Jun/Jul 2025 Makeup — Type conversion and casting with a code snippet.
public class TypeConversionCasting {
    public static void main(String[] args) {
        // --- Implicit conversion (widening) — automatic, no data loss ---
        int num = 100;
        double widened = num;          // int -> double, done automatically
        char ch = 'A';
        int code = ch;                 // char -> int, done automatically

        // --- Explicit conversion (narrowing / casting) — manual, may lose data ---
        double price = 199.99;
        int narrowed = (int) price;    // must cast; result is 199 (truncated, not rounded)

        System.out.println("Implicit: int " + num + " -> double " + widened);
        System.out.println("Implicit: char " + ch + " -> int " + code);
        System.out.println("Explicit: double " + price + " -> int " + narrowed + " (cast, truncated)");
    }
}
