// 1. Single: B extends A
class A { void a() { System.out.println("A: grandparent method"); } }
class B extends A { void b() { System.out.println("B: child of A"); } }

// 2. Multilevel: C extends B extends A
class C extends B { void c() { System.out.println("C: child of B"); } }

// 3. Hierarchical: D and E both extend A
class D extends A { void d() { System.out.println("D: another child of A"); } }
class E extends A { void e() { System.out.println("E: another child of A"); } }

// 4. Multiple (through interfaces; Java does not allow multiple classes)
interface Printable { void print(); }
interface Showable  { void show(); }
class F implements Printable, Showable {
    public void print() { System.out.println("F: print()"); }
    public void show()  { System.out.println("F: show()"); }
}

public class InheritanceTypes {
    public static void main(String[] args) {
        System.out.println("--- Single ---");       new B().a(); new B().b();
        System.out.println("--- Multilevel ---");   C c = new C(); c.a(); c.b(); c.c();
        System.out.println("--- Hierarchical ---"); new D().a(); new D().d(); new E().a(); new E().e();
        System.out.println("--- Multiple (interfaces) ---"); F f = new F(); f.print(); f.show();
    }
}
