# Java Question Bank — ALL 16 Answers (VTU 20-mark style)

Subject: Object Oriented Programming with Java (BCS306A) | Semester III | VTU

Every answer follows the same exam pattern: **Definition -> Points -> Syntax -> Program with Output**.
All 16 questions are answered in full below. Every program is in the `programs/` folder (one folder
per question, `programs/Q1` ... `programs/Q16`) and every one was **compiled and run on JDK 17**.
The outputs shown are the real outputs.

**Contents:** 1. OOP principles | 2. Type conversion, casting, promotion | 3. Arrays + matrix addition |
4. Looping statements | 5. for and for-each | 6. Constructors | 7. Access specifiers | 8. Method overloading |
9. Method overriding + `super` | 10. `final` | 11. Recursion | 12. Inheritance (single) |
13. Types of inheritance | 14. Abstract class and method | 15. Operators, precedence, associativity |
16. Lexical issues.

---
## 1. Explain the object-oriented principles (features) of OOP in detail.

### Definition
Object-Oriented Programming (OOP) is a programming approach that organizes a
program around **objects** (data + the methods that work on it) instead of
around functions. Its four principles are **Abstraction, Encapsulation,
Inheritance and Polymorphism**.

### Syntax
```java
abstract class ClassName { abstract returnType methodName(); }   // abstraction
class ClassName { private dataType variableName; }   // encapsulation (private data)
class SubClass extends SuperClass { }   // inheritance
returnType methodName(parameters) { }   // polymorphism: overloading/overriding
```

### Two Paradigms (background)
1. **Process-oriented (procedural):** code acts on data; data is global and
   less protected. Example: C.
2. **Object-oriented:** data and code are bundled into objects; data is
   protected. Example: Java.

### Principle 1: Abstraction
Hiding the complex implementation and showing only the essential features.
1. Focus on **what** an object does, not **how**.
2. Real life: you drive a car using steering, pedals; you don't need to know
   how the engine works.
3. In Java: achieved using **abstract classes** and **interfaces**.
4. Manages complexity and lets the internal code change without affecting users.
```java
abstract class Shape { abstract double area(); }   // only WHAT
```

### Principle 2: Encapsulation
Binding data and the methods that operate on it into one unit (the **class**),
and protecting the data from outside access.
1. Variables are kept `private`; accessed through `public` getter/setter methods.
2. Also called **data hiding**.
3. Gives control: a setter can validate before changing data.
4. Real life: a medicine capsule keeps the contents safe inside.
```java
class Circle {
    private double r;                       // hidden
    public double getR() { return r; }
    public void setR(double r) { if (r > 0) this.r = r; }   // validation
}
```

### Principle 3: Inheritance
One class (subclass) acquires the properties and methods of another class
(superclass) using the `extends` keyword.
1. Promotes **code reusability**: write common code once.
2. Creates an **IS-A** relationship (Circle IS-A Shape).
3. Subclass can add new members or override inherited methods.
4. Java supports single, multilevel and hierarchical inheritance (multiple
   inheritance of classes is not allowed; use interfaces).
```java
class Animal { void eat() {} }
class Dog extends Animal { void bark() {} }
```

### Principle 4: Polymorphism
"Many forms": the same method name behaves differently in different situations.
1. **Compile-time polymorphism:** method **overloading** (same name, different
   parameters, same class).
2. **Run-time polymorphism:** method **overriding** (subclass redefines the
   superclass method; chosen at run time by the actual object).
3. Real life: the same person is a student, a son and a friend.
```java
static int add(int a, int b)       { return a + b; }
static double add(double a, double b) { return a + b; }   // overloading
```

### Program (`programs/Q1/OOPPrinciplesDemo.java`)
```java
abstract class Shape { abstract double area(); }           // ABSTRACTION
class Circle extends Shape {                               // INHERITANCE
    private double r;                                      // ENCAPSULATION
    Circle(double r) { this.r = r; }
    double area() { return 3.14159 * r * r; }              // POLYMORPHISM (override)
}
class Rectangle extends Shape {
    private double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
public class OOPPrinciplesDemo {
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    public static void main(String[] args) {
        Shape s1 = new Circle(5), s2 = new Rectangle(4, 6);
        System.out.println("Circle area    = " + s1.area());
        System.out.println("Rectangle area = " + s2.area());
        System.out.println(add(2, 3) + " " + add(2.5, 3.5));
    }
}
```

**Output:**
```

Circle area    = 78.53975
Rectangle area = 24.0
5 6.0
```


---

## 2. Explain type conversion, type casting and automatic type promotion in Java with suitable examples.

**Definition:**
- **Type conversion:** the compiler changes one data type to another automatically.
- **Type casting:** the programmer changes one data type to another manually using brackets.

**Syntax:**
```java
biggerType variable = smallerTypeValue;            // conversion (automatic)
smallerType variable = (smallerType) biggerValue;  // casting (manual)
```

### A. Type Conversion (Widening, automatic)

1. Done by the compiler without any extra code.
2. It happens only when both conditions are true: the two types are compatible, and the destination type is bigger than the source type.
3. No data is lost.
4. The order is: `byte -> short -> int -> long -> float -> double`. Also `char -> int`.
5. Number types are not compatible with `boolean`.

**Example:**
```java
int i = 100;
long l = i;           // int to long
float f = l;          // long to float
double d = f;         // float to double
System.out.println(i + " " + l + " " + f + " " + d);
```
Output: `100 100 100.0 100.0`

### B. Type Casting (Narrowing, manual)

1. Needed when a bigger type is put into a smaller type.
2. The target type is written in brackets before the value.
3. Data may be lost.
4. For `double` to `int`, the decimal part is cut off (truncated, not rounded). `(int) 9.99` gives `9`.
5. When a value is too big for the target type, it is reduced by the range of that type. `(byte) 300` gives `44` because 300 - 256 = 44.
6. `char` and `int` can be cast to each other.

**Example:**
```java
double x = 9.99;
int y = (int) x;               // 9
int big = 300;
byte b = (byte) big;           // 44
char c = 'A';
int code = c;                  // 65
char next = (char) (c + 1);    // 'B'
```
Output: `9.99 -> 9`, `300 -> 44`, `A 65 B`

### C. Automatic type promotion in expressions

1. In an expression, `byte`, `short` and `char` are first promoted to `int`.
2. If any one operand is `long`, `float` or `double`, the whole expression is promoted to that type.
3. So `byte * byte` gives an `int`.

**Example:**
```java
byte p = 50, q = 20;
int r = p * q;                 // 1000, would not fit in a byte
System.out.println(7 / 2);             // 3 (int division)
System.out.println((double) 7 / 2);    // 3.5
```

### Difference

| Type Conversion | Type Casting |
|---|---|
| Done automatically by compiler | Done manually by programmer |
| Smaller to bigger type | Bigger to smaller type |
| No data loss | Data may be lost |
| No brackets needed | Needs `(type)` |


### Program (all together)
```java
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
```
**Output:**
```
Widening : 100 -> 100 -> 100.0 -> 100.0
(int) 9.99 = 9, (byte) 300 = 44
char 'A' -> int 65, cast back -> 'B'
byte*byte promoted to int = 1000
7 / 2 = 3, (double) 7 / 2 = 3.5
```


---

## 3. How to create and initialize an Array? Write a Java program to implement the addition of two matrices.

**Definition:** An array is a group of variables of the same data type stored under one name. Each element is accessed with an index, and the index starts from 0.

**Syntax:**
```java
dataType[] arrayName = new dataType[size];
```

### Creating an array (two steps)

1. **Declare** the array variable: `int[] a;`
2. **Allocate memory** using `new`: `a = new int[5];`
3. Both can be written in one line: `int[] a = new int[5];`
4. The default value is 0 for numbers, `false` for boolean and `null` for objects.
5. The size of an array is found using `a.length`.

### Initializing an array

**1. Using index**
```java
int[] a = new int[5];
a[0] = 10;
```

**2. At the time of declaration**
```java
int[] b = {10, 20, 30};
```

**3. Using a loop**
```java
int[] c = new int[3];
for (int i = 0; i < 3; i++) c[i] = i * 10;
```

Output for `a[0]`, `a[1]`, `b[2]`, `c[2]`, `b.length` is `10 0 | 30 | 20 | length = 3`.

### Two dimensional array

**Syntax:**
```java
dataType[][] arrayName = new dataType[rows][columns];
```
```java
int[][] m = {{1, 2}, {3, 4}};      // 2 rows, 2 columns
```
`m[0][1]` is the element in row 0 and column 1, which is `2`.

### Program: addition of two matrices

**Logic:** Add the elements at the same position: `sum[i][j] = m1[i][j] + m2[i][j]`. Matrices must have the same number of rows and columns.

```java
public class MatrixAdd {
    public static void main(String[] args) {
        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{5, 6}, {7, 8}};
        int[][] sum = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                sum[i][j] = m1[i][j] + m2[i][j];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) System.out.print(sum[i][j] + " ");
            System.out.println();
        }
    }
}
```
**Output:**
```
6 8
10 12
```


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

## 6. What are constructors? Explain the types of constructors with an example program.

**Definition:** A constructor is a special method that initializes an object immediately when it is created. It is called automatically when we use the `new` keyword.

**Syntax:**
```java
ClassName(parameters) { statements; }
```

### Rules of a constructor

1. The constructor name must be the same as the class name.
2. It has no return type, not even `void`. The implicit return type is the class type itself.
3. It is called automatically at the time of object creation.
4. If we do not write any constructor, Java supplies a default one. It sets all instance variables to zero (or `null` / `false`).
5. Once we write our own constructor, the default constructor is no longer supplied.
6. Constructors can be overloaded, which means one class can have many constructors with different parameters.

### Types of constructors

#### 1. Default constructor (no parameters)
Gives the same fixed values to every object.
```java
Box() { width = height = depth = -1; }
```

#### 2. Parameterized constructor
Takes parameters, so different objects can get different values.
```java
Box(double w, double h, double d) { width = w; height = h; depth = d; }
```
Also, `Box(double len)` is a parameterized constructor used to make a cube.

#### 3. Copy constructor
Takes an object of the same class as a parameter and copies its values into the new object.
```java
Box(Box ob) { width = ob.width; height = ob.height; depth = ob.depth; }
```

### Constructor vs Method

| Constructor | Method |
|---|---|
| Initializes a new object | Does operations on an existing object |
| Name same as class name | Name can be anything |
| No return type | Must have a return type |
| Called automatically by `new` | Called by the programmer |
| Cannot be inherited | Can be inherited |

### Program
```java
class Box {
    double width, height, depth;
    Box() { width = height = depth = -1; }                       // default
    Box(double len) { width = height = depth = len; }            // cube
    Box(double w, double h, double d) { width = w; height = h; depth = d; }   // parameterized
    Box(Box ob) { width = ob.width; height = ob.height; depth = ob.depth; }   // copy
    double volume() { return width * height * depth; }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 15);
        Box b2 = new Box();
        Box cube = new Box(7);
        Box clone = new Box(b1);
        System.out.println("Volume of b1 is " + b1.volume());
        System.out.println("Volume of b2 is " + b2.volume());
        System.out.println("Volume of cube is " + cube.volume());
        System.out.println("Volume of clone is " + clone.volume());
    }
}
```
**Output:**
```
Volume of b1 is 3000.0
Volume of b2 is -1.0
Volume of cube is 343.0
Volume of clone is 3000.0
```
The constructor to run is chosen by the arguments given in `new`.


---

## 7. Explain the various access specifiers in Java.

**Definition:** Access specifiers (access modifiers) decide which code can access a class member (variable or method). By allowing access only through a well-defined set of methods, we can prevent misuse of the data. This is called data hiding (encapsulation).

**Syntax:**
```java
accessSpecifier dataType variableName;
accessSpecifier returnType methodName(parameters) { }
```

Java has four access levels: `public`, `protected`, default (no keyword) and `private`.

### 1. public
1. Can be accessed by any other code, from anywhere.
2. `main()` is always `public` because it is called by the Java run-time system, which is outside the program.
```java
public int a;
```

### 2. protected
1. Can be accessed in the same package, and also by subclasses in other packages.
2. It matters only when inheritance is involved.
```java
protected int b;
```

### 3. default (no keyword)
1. When no specifier is written, the member is public within its own package, but cannot be accessed outside the package.
```java
int c;
```

### 4. private
1. Can be accessed only by the other members of its own class.
2. Outside code must use public methods (getter and setter).
```java
private int d;
```

### Table

| Specifier | Same class | Same package | Subclass (other package) | Other package |
|---|---|---|---|---|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | No |
| default | Yes | Yes | No | No |
| private | Yes | No | No | No |

### Program
```java
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
        ob.setd(100);      // OK, through the method
        System.out.println("a, b, c and d: " + ob.a + " " + ob.b + " " + ob.c + " " + ob.getd());
    }
}
```
**Output:**
```
a, b, c and d: 10 20 30 100
```
If we remove the `//` before `ob.d = 100;`, the program will not compile because of the access violation.


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

## 11. Define recursion. Write a recursive program to find the factorial of a number.

**Definition:** Recursion is the process of defining something in terms of itself. In Java, it is the feature that allows a method to call itself. A method that calls itself is called a recursive method.

**Syntax:**
```java
returnType methodName(parameters) { if (base condition) return value; return methodName(smaller value); }
```

### Points

1. A recursive method must have a **base case**. This is the condition that stops the calls.
2. It also has a **recursive case**, where the method calls itself with a smaller value.
3. If the base case is missing, the method never returns and we get `StackOverflowError`.
4. Every call gets its own new local variables and parameters on the stack. When the calls return, they are removed.
5. Recursion makes the code of some problems (factorial, Fibonacci, tree traversal) clearer and simpler than loops.
6. The disadvantage is that it uses more memory because of the stack.

### Factorial

The factorial of N is the product of all numbers from 1 to N. Example: 3! = 1 x 2 x 3 = 6.

```java
int fact(int n) {
    if (n == 1) return 1;          // base case
    return fact(n - 1) * n;        // recursive call
}
```

### Working of fact(3)
```
fact(3) = fact(2) * 3
fact(2) = fact(1) * 2
fact(1) = 1                  <- base case, calls start returning
fact(2) = 1 * 2 = 2
fact(3) = 2 * 3 = 6
```

### Program
```java
class Factorial {
    int fact(int n) {
        if (n == 1) return 1;
        return fact(n - 1) * n;
    }
}
public class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println("Factorial of 3 is " + f.fact(3));
        System.out.println("Factorial of 4 is " + f.fact(4));
        System.out.println("Factorial of 5 is " + f.fact(5));
    }
}
```
**Output:**
```
Factorial of 3 is 6
Factorial of 4 is 24
Factorial of 5 is 120
```

### One more example: printing an array recursively
```java
void printArray(int i) {
    if (i == 0) return;                      // base case
    printArray(i - 1);                       // recursive call
    System.out.println("[" + (i - 1) + "] " + values[i - 1]);
}
```
Calling `printArray(5)` prints `[0] 0`, `[1] 1`, `[2] 2`, `[3] 3`, `[4] 4`.


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

## 15. Explain the different types of operators in Java. Explain operator precedence and associativity with suitable examples.

### Definition
An operator is a symbol that performs an operation on one or more operands
(values/variables) and produces a result.

### Syntax
```java
operand1 operator operand2;   // e.g. result = a + b; or variable = (condition) ? value1 : value2;
```

### Types of Operators

#### 1. Arithmetic: `+ - * / %`
1. `+` add, `-` subtract, `*` multiply, `/` divide, `%` remainder (modulus).
2. Integer division discards the fraction: `10 / 3 = 3`; `10 % 3 = 1`.

#### 2. Unary: `+ - ++ -- !`
1. `++` / `--` increase / decrease by 1.
2. **Post** (`x++`): use the value, then change it. **Pre** (`++x`): change it, then use it.
3. `-x` negates; `!` reverses a boolean.

#### 3. Relational: `== != > < >= <=`
1. Compare two values; the result is always `boolean`.
2. Used in `if` and loops.

#### 4. Logical: `&& || !`
1. `&&` AND (true only if both true), `||` OR (true if any true), `!` NOT.
2. **Short-circuit:** `&&` skips the right side if the left is false; `||`
   skips it if the left is true.

#### 5. Assignment: `= += -= *= /= %=`
1. `x += 5` means `x = x + 5` (compound assignment).

#### 6. Bitwise: `& | ^ ~`
Work on individual bits of integers. With `5 = 0101`, `3 = 0011`:
`5 & 3 = 1`, `5 | 3 = 7`, `5 ^ 3 = 6`, `~5 = -6`.

#### 7. Shift: `<< >> >>>`
1. `<<` left shift: multiplies by 2 per shift (`8 << 2 = 32`).
2. `>>` signed right shift: divides by 2, keeps sign (`8 >> 2 = 2`).
3. `>>>` unsigned right shift: fills with 0 (`-8 >>> 28 = 15`).

#### 8. Ternary: `? :`
Short form of if-else: `result = (condition) ? value1 : value2;`

#### 9. instanceof
Checks whether an object belongs to a class; returns `boolean`.

### Program (`programs/OperatorsDemo.java`)
```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println("a+b=" + (a+b) + " a-b=" + (a-b) + " a*b=" + (a*b) + " a/b=" + (a/b) + " a%b=" + (a%b));
        int x = 5;
        System.out.println("x++=" + (x++) + " x=" + x + " ++x=" + (++x) + " -x=" + (-x));
        System.out.println("a>b " + (a>b) + ", a==b " + (a==b) + ", a!=b " + (a!=b));
        System.out.println("&&: " + (a>5 && b<5) + "  ||: " + (a<5 || b<5) + "  !: " + !(a>5));
        int c = 5; c += 3; c *= 2;
        System.out.println("c=" + c);
        System.out.println("5&3=" + (5&3) + " 5|3=" + (5|3) + " 5^3=" + (5^3) + " ~5=" + (~5));
        System.out.println("8<<2=" + (8<<2) + " 8>>2=" + (8>>2) + " -8>>>28=" + (-8>>>28));
        int max = (a > b) ? a : b;
        System.out.println("max=" + max);
        String s = "hi";
        System.out.println("s instanceof String: " + (s instanceof String));
    }
}
```

**Output:**
```

a+b=13 a-b=7 a*b=30 a/b=3 a%b=1
x++=5 x=6 ++x=7 -x=-7
a>b true, a==b false, a!=b true
&&: true  ||: true  !: false
c=16
5&3=1 5|3=7 5^3=6 ~5=-6
8<<2=32 8>>2=2 -8>>>28=15
max=10
s instanceof String: true
```


---

### Operator precedence and associativity

### Definition
- **Precedence:** decides which operator is evaluated **first** when an
  expression has several different operators (higher precedence first).
- **Associativity:** decides the order (left-to-right or right-to-left) when
  operators have the **same precedence**.

### Syntax
```java
result = operand1 operator1 operand2;   // order decided by precedence table
```

### Precedence Table (highest to lowest)
| Level | Operators | Associativity |
|---|---|---|
| 1 | `()` `[]` `.` | left to right |
| 2 | `x++` `x--` (postfix) | left to right |
| 3 | `++x` `--x` `+x` `-x` `!` `~` (unary) | **right to left** |
| 4 | `*` `/` `%` | left to right |
| 5 | `+` `-` | left to right |
| 6 | `<<` `>>` `>>>` | left to right |
| 7 | `<` `<=` `>` `>=` `instanceof` | left to right |
| 8 | `==` `!=` | left to right |
| 9 | `&` | left to right |
| 10 | `^` | left to right |
| 11 | `\|` | left to right |
| 12 | `&&` | left to right |
| 13 | `\|\|` | left to right |
| 14 | `? :` (ternary) | **right to left** |
| 15 | `=` `+=` `-=` ... | **right to left** |

### Examples
1. `10 + 5 * 2 = 20` : `*` has higher precedence than `+`.
2. `(10 + 5) * 2 = 30` : parentheses override precedence.
3. `100 / 10 * 2 = 20` : `/` and `*` are equal, so **left to right**: (100/10)*2.
4. `a = b = c = 5` : assignment is **right to left**: c=5, then b=c, then a=b.
5. `2 + 3 + "A" + 2 + 3 = 5A23` : `+` is left to right; 2+3=5 first, then string joining.

### Program (`programs/PrecedenceDemo.java`)
```java
public class PrecedenceDemo {
    public static void main(String[] args) {
        System.out.println(10 + 5 * 2);
        System.out.println((10 + 5) * 2);
        System.out.println(100 / 10 * 2);
        System.out.println(2 + 3 > 4 && 1 < 2);
        int a, b, c;
        a = b = c = 5;
        System.out.println(a + " " + b + " " + c);
        int x = 2;
        int y = x++ + ++x * 2;
        System.out.println(y + " " + x);
        System.out.println(true ? 1 : false ? 2 : 3);
        System.out.println(2 + 3 + "A" + 2 + 3);
    }
}
```

**Output:**
```

20
30
20
true
5 5 5
10 4          <- x++ gives 2 (x becomes 3); ++x makes x 4, gives 4; 2 + 4*2 = 10
1
5A23
```


---

## 16. Explain the different lexical issues in Java.

**Definition:** Lexical issues are the basic building blocks used to write a Java program. Before understanding the meaning, the compiler first breaks the program into these small parts, called tokens. A Java program is made of whitespace, identifiers, literals, comments, separators and keywords.

**Syntax:**
```java
dataType identifier = literal;
```

### 1. Whitespace

1. Whitespace means space, tab, new line and form feed.
2. Java is a free-form language, so we need not follow any special indentation.
3. Extra spaces and blank lines are ignored by the compiler.
4. At least one whitespace is needed between two words like `int x`, otherwise `intx` becomes one name.

**Example:**
```java
int      studentAge   =   20;      // same as: int studentAge = 20;
```

### 2. Identifiers

1. Identifiers are the names given to classes, methods and variables.
2. They can contain letters, digits, underscore `_` and dollar `$`.
3. They must not start with a digit.
4. They are case sensitive, so `Total` and `total` are different.
5. A keyword cannot be used as an identifier.
6. Valid: `marks1`, `_count`, `$total`. Invalid: `2marks`, `my-name`, `int`.

**Syntax:**
```java
dataType identifierName;
```

**Example:**
```java
int _count = 5, $total = 10, marks1 = 85;     // valid identifiers
// int 2marks = 3;                            // error: starts with a digit
```

### 3. Literals

1. A literal is a fixed value written directly in the program.
2. Types: integer, floating-point, character, string, boolean and null.

| Type | Example |
|---|---|
| Integer | `100`, `0x1F` (hex), `0b101` (binary), `1_000_000` |
| Floating-point | `3.14`, `2.5f` |
| Character | `'A'` |
| String | `"Ravi"` |
| Boolean | `true`, `false` |
| Null | `null` |

**Example:**
```java
double pi = 3.14;
char grade = 'A';
String name = "Ravi";
boolean pass = true;
int hex = 0x1F, bin = 0b101, big = 1_000_000;
String nothing = null;
```

### 4. Comments

1. Comments are ignored by the compiler. They are used to explain the code.
2. Three types: single line `//`, multi line `/* */` and documentation `/** */`.

**Syntax:**
```java
// single line comment
/* multi line comment */
/** documentation comment */
```

**Example:**
```java
// this is a single line comment
/* this comment
   goes to two lines */
/** Main method of the program */
```

### 5. Separators

1. Separators are symbols that separate or group the code.

| Symbol | Name | Use |
|---|---|---|
| `;` | Semicolon | ends a statement |
| `,` | Comma | separates variables |
| `.` | Period | access a member (`System.out`) |
| `( )` | Parentheses | method calls and conditions |
| `{ }` | Braces | block of code, array values |
| `[ ]` | Brackets | arrays |

**Example:**
```java
int[] arr = {1, 2, 3};                 // [ ] { } , ;
System.out.println(arr[0]);            // . ( ) [ ] ;
```

### 6. Keywords

1. Keywords are reserved words that have a fixed meaning in Java.
2. They cannot be used as identifier names.
3. All keywords are in lowercase. Java has 50 keywords, for example `class`, `public`, `static`, `int`, `if`, `for`, `new`, `return`.
4. `true`, `false` and `null` are also reserved and cannot be used as names.

**Example:**
```java
public class LexicalDemo { }       // public, class are keywords; LexicalDemo is an identifier
```

### Program (all six together)
```java
public class LexicalDemo {                 // keywords: public, class | identifier: LexicalDemo
    /* multi-line comment */
    public static void main(String[] args) {
        int      studentAge   =   20;       // whitespace
        int _count = 5, $total = 10, marks1 = 85;   // identifiers
        double pi = 3.14;                   // literals
        char grade = 'A';
        String name = "Ravi";
        boolean pass = true;
        int hex = 0x1F, bin = 0b101, big = 1_000_000;
        String nothing = null;
        int[] arr = {1, 2, 3};              // separators
        System.out.println(name + " " + studentAge + " " + grade + " " + pi + " " + pass);
        System.out.println(_count + " " + $total + " " + marks1);
        System.out.println(hex + " " + bin + " " + big + " " + nothing + " " + arr[0]);
    }
}
```
**Output:**
```
Ravi 20 A 3.14 true
5 10 85
31 5 1000000 null 1
```

