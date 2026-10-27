# OOPS with Java — Important Questions (VTU, BCS306A, 2025 Scheme)

This repo has **exam-ready, structured answers** for VTU 3rd semester "Object Oriented
Programming with Java" (BCS306A) — starting with **Module 1: Overview of Java, Data
Types, Operators, Control Statements**.

Source material: 8 previous-year BCS306A papers (Dec 2023 → Dec 2025, + Model Paper +
Undated paper) + personal class notes on OOP concepts. Notes were used as reference,
not copied word-for-word — answers are written to be easy, understandable, and
sufficient for full marks at a 3rd sem level.

## How every answer is structured

For every question:

1. **Definition** — one or two lines, exam-safe.
2. **Points** — 5 to 10 easy bullet points explaining it.
3. **Syntax** — wherever applicable.
4. **Easiest Program** — a clean, complete, working solution.
5. **Smallest Program** — the shortest valid version that still answers the question.

## Contents

### Java Question Bank (16 questions, 20-mark VTU style)

| File | Covers |
|---|---|
| [Java-Question-Bank/Java-Question-Bank-Answers.md](Java-Question-Bank/Java-Question-Bank-Answers.md) | Looping statements, for and for-each, method overloading, method overriding and `super`, `final`, inheritance (single and all types), abstract class and method, plus a quick map linking all 16 questions to their full answers |
| [Java-Question-Bank/programs/](Java-Question-Bank/programs/) | 8 runnable programs (one folder per question), all compiled and run on JDK 17 |

### Java Assignment 1 (college assignment, 10 questions, detailed answers)

| File | Covers |
|---|---|
| [Java-Assignment-1/Java-Assignment-1.md](Java-Assignment-1/Java-Assignment-1.md) | Lexical issues, for loop, type conversion and casting, arrays + matrix addition, constructors, recursion (factorial), access specifiers, call by value/reference, `this`, method overriding |
| [Java-Assignment-1/programs/](Java-Assignment-1/programs/) | 10 runnable programs (one folder per question), all compiled and run |

### College IMP Questions (10 questions from the college sheet)

| File | Covers |
|---|---|
| [Module1-College-IMP/Java-Module1-College-IMP.md](Module1-College-IMP/Java-Module1-College-IMP.md) | The 10 college "JAVA – Module 1 QUESTIONS": lexical issues, OOP principles, operators, selection statements, looping statements, for statement + variations, jump statements, type conversion & casting, operator precedence & associativity, primitive data types |
| [Module1-College-IMP/programs/](Module1-College-IMP/programs/) | 10 runnable `.java` programs, all compiled and run (JDK 17) with outputs shown in the answers |

### Question-Answer Format (each question exactly as in the IMP PDF, with answer below)

| File | Paper |
|---|---|
| [Paper1-Dec2023-Jan2024.md](Module1-Question-Answers/Paper1-Dec2023-Jan2024.md) | BCS306A Dec 2023/Jan 2024 Exam |
| [Paper2-JunJul2024.md](Module1-Question-Answers/Paper2-JunJul2024.md) | BCS306A June/July 2024 Exam |
| [Paper3-Dec2024-Jan2025.md](Module1-Question-Answers/Paper3-Dec2024-Jan2025.md) | BCS306A Dec 2024/Jan 2025 Exam |
| [Paper4-JunJul2025.md](Module1-Question-Answers/Paper4-JunJul2025.md) | BCS306A June/July 2025 Exam |
| [Paper5-JunJul2025-Makeup.md](Module1-Question-Answers/Paper5-JunJul2025-Makeup.md) | BCS306A June/July 2025 Makeup Exam |
| [Paper6-Dec2025-Jan2026.md](Module1-Question-Answers/Paper6-Dec2025-Jan2026.md) | BCS306A Dec 2025/Jan 2026 Exam |
| [Paper7-ModelQuestionPaper.md](Module1-Question-Answers/Paper7-ModelQuestionPaper.md) | BCS306A Model Question Paper (2023-24 CBCS) |
| [Paper8-UndatedExamPaper.md](Module1-Question-Answers/Paper8-UndatedExamPaper.md) | BCS306A Undated Exam Paper |

### Topic-Organized Format (by concept, with question-mapping index)

| File | Covers |
|---|---|
| [01-Two-Paradigms-and-OOP-Principles.md](Module1-OOP-Java-IMP/01-Two-Paradigms-and-OOP-Principles.md) | Procedural vs OOP, Java features, Abstraction, Encapsulation, Inheritance, Polymorphism |
| [02-Lexical-Issues.md](Module1-OOP-Java-IMP/02-Lexical-Issues.md) | Whitespace, Identifiers, Literals, Comments, Separators, Keywords |
| [03-Data-Types.md](Module1-OOP-Java-IMP/03-Data-Types.md) | Primitive (8 types) + Non-primitive types, default values, literals |
| [04-Type-Conversion-Casting-Promotion.md](Module1-OOP-Java-IMP/04-Type-Conversion-Casting-Promotion.md) | Widening, Narrowing/Casting, Automatic Type Promotion, Variable Scope |
| [05-Arrays.md](Module1-OOP-Java-IMP/05-Arrays.md) | 1D & 2D arrays, matrix programs, search, sort, for-each |
| [06-Operators.md](Module1-OOP-Java-IMP/06-Operators.md) | Arithmetic, Unary, Relational, Logical, Assignment, Bitwise, Shift, Ternary, instanceof, Precedence |
| [07-Control-Statements.md](Module1-OOP-Java-IMP/07-Control-Statements.md) | if / switch, while / do-while / for / for-each, break / continue / return |
| [08-Question-Mapping-Index.md](Module1-OOP-Java-IMP/08-Question-Mapping-Index.md) | Every IMP question mapped to the section/program that answers it |
| [programs/](Module1-OOP-Java-IMP/programs/) | All standalone runnable `.java` files referenced above |

## Programs

All standalone `.java` files are in [Module1-OOP-Java-IMP/programs/](Module1-OOP-Java-IMP/programs/):
- `ArrayDemo.java` — 1D & 2D array declaration, initialization, traversal
- `AverageArray.java` — Average of {8, 6, 2, 7}
- `AverageForEach.java` — Average of {1,2,3,4,5} using for-each
- `BreakContinueDemo.java` — break and continue jump statements
- `CelsiusToFahrenheit.java` — Temperature conversion
- `ControlStatementsDemo.java` — All control statements with examples
- `DataTypesDemo.java` — All primitive types, defaults, literals
- `ForEach2DArray.java` — 2D array with for-each loop
- `ForLoopTrace.java` — For loop output tracing template
- `IfStatementTypes.java` — All 4 types of if statements
- `LinearSearch.java` — Linear search with keyboard input
- `MatrixAddition.java` — 2×2 matrix addition
- `MatrixAdditionN.java` — Order-N matrix addition
- `MatrixAdditionCLI.java` — Matrix addition using command line args
- `PrimeCheck.java` — Prime number check with a method
- `ShiftAndBitwiseDemo.java` — Bitwise & shift operators (<<, >>, >>>)
- `SortForLoop.java` — Bubble sort using for loop
- `TernaryGreatest.java` — Greatest of 3 using ternary operator
- `TransposeMatrix.java` — Matrix transpose
- `TypeConversionCasting.java` — Type conversion and casting

More modules will be added here as they're prepared.
