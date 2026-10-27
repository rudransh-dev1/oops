public class LoopsDemo {
    public static void main(String[] args) {
        int i = 1;
        System.out.print("while     : ");
        while (i <= 5) { System.out.print(i + " "); i++; }

        i = 1;
        System.out.print("\ndo-while  : ");
        do { System.out.print(i + " "); i++; } while (i <= 5);

        System.out.print("\nfor       : ");
        for (int j = 1; j <= 5; j++) System.out.print(j + " ");

        int[] marks = {10, 20, 30};
        System.out.print("\nfor-each  : ");
        for (int m : marks) System.out.print(m + " ");

        i = 10;
        System.out.print("\nwhile(false cond) runs: ");
        int w = 0; while (i < 5) { w++; }
        System.out.print(w + " time(s)");
        int d = 0; do { d++; } while (i < 5);
        System.out.println(" | do-while runs: " + d + " time(s)");
    }
}
