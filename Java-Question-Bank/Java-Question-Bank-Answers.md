# Java Question Bank: 20-Mark Answers (VTU style)

Subject: Object Oriented Programming with Java (BCS306A) | Semester III | VTU

Every answer follows the same exam pattern: **Definition, Points, Syntax, Program with Output**.
Every program is in the `programs/` folder (one folder per question) and was **compiled and run on JDK 17**.
The output shown is the real output.

> Questions 1, 2, 3, 6, 7, 11, 15 and 16 are already answered in detail in this repo. Links are in the
> [Quick Map](#quick-map-all-16-questions) at the bottom. This file adds full answers for the remaining
> ones (4, 5, 8, 9, 10, 12, 13, 14) so the whole question bank is covered.

---

## 4. Describe the looping statements available in Java.

**Definition:** A looping (iteration) statement repeats a block of statements again and again as long as a given condition is true. Java has four loops: `while`, `do-while`, `for` and the for-each (enhanced `for`).

**Syntax:**
```java
while (condition) { statements; }
do { statements; } while (condition);
for (initialization; condition; update) { statements; }
for (dataType variable : arrayOrCollection) { statements; }
```

### Points

1. **while** is an *entry-controlled* loop. The condition is checked first, so the body may run **zero** times.
2. **do-while** is an *exit-controlled* loop. The body runs first and the condition is checked after, so the body runs **at least once**. It ends with a semicolon.
3. **for** puts initialization, condition and update in one line. It is best when the number of repetitions is known.
4. **for-each** goes through every element of an array or collection one by one, without an index.
5. A loop placed inside another loop is a **nested loop**. The inner loop finishes fully for each turn of the outer loop.
6. `break` leaves the loop immediately and `continue` skips to the next repetition.

| Feature | while | do-while | for | for-each |
|---|---|---|---|---|
| Condition checked | Before body | After body | Before body | No condition, goes to the last element |
| Minimum runs | 0 | 1 | 0 | 0 |
| Type | Entry-controlled | Exit-controlled | Entry-controlled | Entry-controlled |
| Best used when | Count unknown | Must run once | Count known | Reading all elements |

### Program
```java
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
```
**Output:**
```
while     : 1 2 3 4 5
do-while  : 1 2 3 4 5
for       : 1 2 3 4 5
for-each  : 10 20 30
while(false cond) runs: 0 time(s) | do-while runs: 1 time(s)
```

---

## 5. Explain the for loop and enhanced for loop (for-each loop) in detail with suitable examples.

**Definition:** The `for` loop is a compact entry-controlled loop that keeps initialization, condition and update together in one line. The enhanced `for` (for-each) loop reads every element of an array or collection in order, without using an index.

**Syntax:**
```java
for (initialization; condition; update) { statements; }
for (dataType variable : arrayOrCollection) { statements; }
```

### Points: for loop

1. **Initialization** runs only once, before the loop starts.
2. **Condition** is checked before every repetition. The loop stops when it becomes false.
3. **Update** runs after every repetition (for example `i++`).
4. Any of the three parts can be left empty, but both semicolons must stay.
5. `for (;;)` is an **infinite loop**. It is stopped with `break` or `return`.
6. More than one variable can be used, separated by commas: `for (int a = 0, b = 6; a < b; a += 2, b -= 2)`.
7. Java 10 allows `var` in a loop: `for (var i = 0; i < 5; i++)`. The compiler works out the type.

### Points: for-each loop

1. It runs once for every element, from the first to the last.
2. No index and no counter are needed, so there are no out-of-range mistakes.
3. The loop variable is only a **copy** of the element. Changing it does **not** change the array.
4. It cannot go backwards, skip elements, or give the index. Use the normal `for` loop for that.

### Program
```java
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
```
**Output:**
```
1 2 3 <- standard for
1 2 3 <- optional expressions
(0,6) (2,4) <- multiple variables
1 2 3 <- infinite for with break
for-each sum = 201
after m=0 in for-each, marks[0] = 45
```

---

## 8. Explain method overloading with a suitable example.

**Definition:** Method overloading means writing two or more methods with the **same name** in the same class, but with **different parameter lists** (different number, type or order of parameters).

**Syntax:**
```java
returnType methodName(type1 a)
returnType methodName(type1 a, type2 b)      // same name, different parameters
```

### Points

1. The method name must be the same in every version.
2. The parameter list must differ in the **number**, the **type** or the **order** of parameters.
3. The **return type is not considered**. Two methods that differ only in return type give a compile-time error.
4. Java decides which version to call by looking at the arguments in the call.
5. This happens at **compile time**, so it is called **compile-time polymorphism** (static binding).
6. If no exact match is found, Java applies automatic type conversion (widening). For example `test(10)` can call `test(double)` if there is no `test(int)`.
7. Constructors can also be overloaded (constructor overloading).
8. Advantages: the code is easier to read, one meaningful name is reused, and there is no need to remember many names.

### Program
```java
class Calculator {
    int add(int a, int b)            { return a + b; }          // 2 int
    int add(int a, int b, int c)     { return a + b + c; }      // 3 int  (number differs)
    double add(double a, double b)   { return a + b; }          // 2 double (type differs)
    String add(String a, String b)   { return a + b; }          // 2 String (type differs)
}
public class OverloadDemo {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
        System.out.println(c.add(1.5, 2.5));
        System.out.println(c.add("Java", "Programming"));
    }
}
```
**Output:**
```
30
60
4.0
JavaProgramming
```

---

## 9. Explain method overriding with a suitable example. Discuss the importance of the `super` keyword with an example.

**Definition:** When a subclass writes a method with the **same name, same parameters and same return type** as a method of its superclass, the subclass method **overrides** the superclass method. The `super` keyword refers to the immediate superclass and is used to reach its members.

**Syntax:**
```java
class Sub extends Super { @Override returnType method(parameters) { statements; } }
super.methodName();         // call superclass method
super(arguments);           // call superclass constructor
super.variableName;         // access superclass variable
```

### Points: method overriding

1. Overriding needs inheritance (`extends`).
2. Name, parameters and return type must be exactly the same.
3. The subclass method cannot have weaker access (a `public` method cannot become `private`).
4. `final`, `static` and `private` methods cannot be overridden.
5. `@Override` is optional but good practice. The compiler reports a mistake in the name or parameters.
6. It is decided at **run time**, so it is **run-time polymorphism** (dynamic method dispatch).
7. A superclass reference can hold a subclass object. The version that runs depends on the **object**, not on the reference.

### Importance of `super`

1. **Call the superclass constructor:** `super(args)` must be the **first statement** of the subclass constructor.
2. **Call the overridden superclass method:** `super.show()` runs the parent version, then the child adds more. This avoids repeating code.
3. **Access a hidden superclass variable** when the subclass has a variable with the same name.
4. If `super(...)` is not written, Java automatically adds `super()` (the no-argument superclass constructor).
5. `super` cannot be used in a `static` method.

### Program
```java
class Person {
    String name;
    Person(String name) { this.name = name; }
    void show() { System.out.println("Name: " + name); }
}
class Student extends Person {
    int marks;
    Student(String name, int marks) {
        super(name);                  // 1. call superclass constructor
        this.marks = marks;
    }
    @Override
    void show() {                     // method overriding
        super.show();                 // 2. call superclass method
        System.out.println("Marks: " + marks);
    }
}
public class SuperDemo {
    public static void main(String[] args) {
        Person p = new Student("Ravi", 85);   // dynamic method dispatch
        p.show();
    }
}
```
**Output:**
```
Name: Ravi
Marks: 85
```

| Overloading | Overriding |
|---|---|
| Same name, different parameters | Same name, same parameters |
| Within the same class | Between superclass and subclass |
| Decided at compile time | Decided at run time |

---

## 10. Explain the uses of the `final` keyword in Java with suitable examples.

**Definition:** `final` is a non-access modifier used to **restrict change**. A `final` variable cannot be changed, a `final` method cannot be overridden, and a `final` class cannot be inherited.

**Syntax:**
```java
final dataType NAME = value;          // final variable
final returnType method() { }         // final method
final class ClassName { }             // final class
```

### Points

| Applied to | Effect | Example |
|---|---|---|
| Variable | Becomes a constant. Value cannot change after it is set | `final int MAX = 100;` |
| Method | Cannot be overridden in a subclass | `final void rules() { }` |
| Class | Cannot be extended by any class | `final class Constants { }` |

1. By convention `final` variable names are written in **UPPERCASE**, for example `MAX_USERS`.
2. A `final` variable must be given a value once. Assigning again gives a compile-time error.
3. `static final` is used for true constants, for example `static final double PI = 3.14159;`.
4. A `final` method is used to protect important logic from being changed by a subclass.
5. A `final` class is used for security and design safety. The `String` class of Java is `final`.
6. A `final` method can still be **inherited and called**, it just cannot be overridden.

### Program
```java
class Parent {
    final void rules() { System.out.println("Final method: cannot be overridden"); }
}
class Child extends Parent {
    // void rules() { }   // ERROR: cannot override final method
}
final class Constants {                       // final class: cannot be extended
    static final double PI = 3.14159;         // final variable: constant
}
// class Sub extends Constants { }            // ERROR: cannot inherit from final class

public class FinalDemo {
    public static void main(String[] args) {
        final int MAX = 100;                  // final variable
        // MAX = 200;                         // ERROR: cannot assign a value to final variable
        System.out.println("MAX = " + MAX);
        System.out.println("PI  = " + Constants.PI);
        new Child().rules();
    }
}
```
**Output:**
```
MAX = 100
PI  = 3.14159
Final method: cannot be overridden
```

---

## 12. What is inheritance? Explain single-level inheritance with a suitable example.

**Definition:** Inheritance is the mechanism by which one class (the **subclass** or child) acquires the variables and methods of another class (the **superclass** or parent). In **single inheritance**, exactly one subclass extends exactly one superclass.

**Syntax:**
```java
class SubClass extends SuperClass { }
```

### Points

1. Inheritance gives **code reusability**. Common code is written once in the superclass.
2. The keyword `extends` is used to inherit.
3. The subclass gets all non-private members of the superclass and can add its own.
4. `private` members are **not directly accessible** in the subclass.
5. It represents an **"is-a" relationship** (a Manager *is an* Employee).
6. Every class in Java inherits from the `Object` class.
7. Single inheritance: `Employee` (superclass) to `Manager` (subclass).

```
Employee   (superclass)
   |
   v
Manager    (subclass)
```

### Program
```java
class Employee {                              // superclass
    String name = "Anita";
    double salary = 30000;
    void display() { System.out.println(name + " earns " + salary); }
}
class Manager extends Employee {              // subclass
    double bonus = 5000;
    void total() { System.out.println("Total pay = " + (salary + bonus)); }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display();                          // inherited method
        m.total();                            // own method
    }
}
```
**Output:**
```
Anita earns 30000.0
Total pay = 35000.0
```

---

## 13. Explain the different types of inheritance in Java with suitable examples.

**Definition:** Based on how classes are connected, inheritance in Java is of these types: **single, multilevel, hierarchical** (using classes) and **multiple** (using interfaces only).

**Syntax:**
```java
class B extends A { }                       // single
class C extends B { }                       // multilevel
class D extends A { }  class E extends A { }  // hierarchical
class F implements I1, I2 { }               // multiple (interfaces)
```

### Points

| Type | Meaning | Diagram |
|---|---|---|
| Single | One subclass extends one superclass | A to B |
| Multilevel | A chain: a subclass becomes the superclass of another | A to B to C |
| Hierarchical | Many subclasses extend one superclass | A to B, A to D, A to E |
| Multiple | One class has more than one parent | Only through **interfaces** |

1. **Multiple inheritance of classes is NOT allowed** in Java. A class can extend only one class. This avoids the *diamond problem*, where two parents have the same method and Java cannot decide which to use.
2. Java supports multiple inheritance through **interfaces**: `class F implements Printable, Showable`.
3. **Hybrid** inheritance (a mix of types) is possible only when interfaces are used.
4. In multilevel inheritance, constructors run from the top superclass down to the subclass.

### Program
```java
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
```
**Output:**
```
--- Single ---
A: grandparent method
B: child of A
--- Multilevel ---
A: grandparent method
B: child of A
C: child of B
--- Hierarchical ---
A: grandparent method
D: another child of A
A: grandparent method
E: another child of A
--- Multiple (interfaces) ---
F: print()
F: show()
```

---

## 14. What is an abstract class and an abstract method? Explain with a suitable example.

**Definition:** An **abstract method** is a method declared without a body (only the signature) using the `abstract` keyword. An **abstract class** is a class declared with `abstract` that may contain abstract methods. It cannot be instantiated, and it is meant to be extended.

**Syntax:**
```java
abstract class ClassName {
    abstract returnType methodName(parameters);     // no body
    returnType normalMethod() { statements; }       // normal method allowed
}
```

### Points

1. An abstract class **cannot be instantiated**: `new Shape()` gives a compile-time error.
2. An abstract method has **no body** and ends with a semicolon.
3. A class that has even one abstract method **must be declared abstract**.
4. An abstract class can also have normal methods, variables and constructors.
5. A subclass **must override every abstract method**, otherwise the subclass must also be declared abstract.
6. An abstract class reference can hold a subclass object, so it supports run-time polymorphism.
7. `abstract` cannot be combined with `final` (final stops overriding), `private` or `static` for methods.
8. Use: it hides implementation details and shows only **what** to do. The subclass decides **how**. This is abstraction.

### Program
```java
abstract class Shape {
    abstract double area();                   // abstract method: no body
    void info() { System.out.println("I am a shape"); }   // normal method
}
class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }
}
class Rectangle extends Shape {
    double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
public class AbstractDemo {
    public static void main(String[] args) {
        // Shape s = new Shape();             // ERROR: cannot create object of abstract class
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        s1.info();
        System.out.println("Circle area    = " + s1.area());
        System.out.println("Rectangle area = " + s2.area());
    }
}
```
**Output:**
```
I am a shape
Circle area    = 78.5
Rectangle area = 24.0
```

---

## Quick Map: all 16 questions

| # | Question | Where the full answer is |
|---|---|---|
| 1 | Features of OOP | [Module1-College-IMP Q2](../Module1-College-IMP/Java-Module1-College-IMP.md) |
| 2 | Type conversion and type promotion | [Assignment 1 Q3](../Java-Assignment-1/Java-Assignment-1.md), [College IMP Q8](../Module1-College-IMP/Java-Module1-College-IMP.md) |
| 3 | Array: declare and initialize | [Assignment 1 Q4](../Java-Assignment-1/Java-Assignment-1.md), [05-Arrays](../Module1-OOP-Java-IMP/05-Arrays.md) |
| 4 | Looping statements | **This file, Q4** |
| 5 | for and enhanced for | **This file, Q5** |
| 6 | Constructors, types, overloading | [Assignment 1 Q5](../Java-Assignment-1/Java-Assignment-1.md) |
| 7 | Access specifiers | [Assignment 1 Q7](../Java-Assignment-1/Java-Assignment-1.md) |
| 8 | Method overloading | **This file, Q8** |
| 9 | Method overriding and `super` | **This file, Q9** (also [Assignment 1 Q10](../Java-Assignment-1/Java-Assignment-1.md)) |
| 10 | `final` keyword | **This file, Q10** |
| 11 | Recursion | [Assignment 1 Q6](../Java-Assignment-1/Java-Assignment-1.md) |
| 12 | Inheritance, single-level | **This file, Q12** |
| 13 | Types of inheritance | **This file, Q13** |
| 14 | Abstract class and method | **This file, Q14** |
| 15 | Operators and precedence | [College IMP Q3, Q9](../Module1-College-IMP/Java-Module1-College-IMP.md) |
| 16 | Lexical issues | [Assignment 1 Q1](../Java-Assignment-1/Java-Assignment-1.md) |
