class Factorial {
    int fact(int n) {
        if (n == 1) return 1;            // base case
        return fact(n - 1) * n;          // recursive call
    }
}
class RecTest {
    int[] values;
    RecTest(int i) { values = new int[i]; }
    void printArray(int i) {             // prints first i elements recursively
        if (i == 0) return;
        printArray(i - 1);
        System.out.println("[" + (i - 1) + "] " + values[i - 1]);
    }
}
public class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println("Factorial of 3 is " + f.fact(3));
        System.out.println("Factorial of 4 is " + f.fact(4));
        System.out.println("Factorial of 5 is " + f.fact(5));
        RecTest ob = new RecTest(5);
        for (int i = 0; i < 5; i++) ob.values[i] = i;
        ob.printArray(5);
    }
}
