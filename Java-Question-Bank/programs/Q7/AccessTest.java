class Test {
    public int a;          // public
    protected int b;       // protected
    int c;                 // default
    private int d;         // private
    void setd(int i) { d = i; }
    int getd() { return d; }
}
public class AccessTest {
    public static void main(String[] args) {
        Test ob = new Test();
        ob.a = 10;
        ob.b = 20;
        ob.c = 30;
        // ob.d = 100;     // error: d has private access in Test
        ob.setd(100);
        System.out.println("a, b, c and d: " + ob.a + " " + ob.b + " " + ob.c + " " + ob.getd());
    }
}
