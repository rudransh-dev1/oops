public class ForLoops {
    public static void main(String[] args) {
        // 1. Standard for loop
        for (int i = 1; i <= 3; i++) System.out.print(i + " ");
        System.out.println("<- standard for");

        // 2. Optional parts: init outside, update inside
        int k = 1;
        for (; k <= 3; ) { System.out.print(k + " "); k++; }
        System.out.println("<- optional expressions");

        // 3. Multiple variables
        for (int a = 0, b = 6; a < b; a += 2, b -= 2)
            System.out.print("(" + a + "," + b + ") ");
        System.out.println("<- multiple variables");

        // 4. Infinite loop stopped using break
        int n = 0;
        for (;;) { if (++n > 3) break; System.out.print(n + " "); }
        System.out.println("<- infinite for with break");

        // 5. Enhanced for (for-each)
        int[] marks = {45, 67, 89};
        int sum = 0;
        for (int m : marks) sum += m;
        System.out.println("for-each sum = " + sum);

        // 6. for-each cannot change the array elements
        for (int m : marks) m = 0;
        System.out.println("after m=0 in for-each, marks[0] = " + marks[0]);
    }
}
