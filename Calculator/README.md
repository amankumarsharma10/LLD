# 🧮 Calculator using Composite Design Pattern

## 📌 Overview
This project implements a **basic calculator** in Java that supports the four fundamental arithmetic operations:
- Addition (`+`)
- Subtraction (`-`)
- Multiplication (`*`)
- Division (`/`)

The calculator is built using the **Composite Design Pattern**, making it flexible and extensible for handling arithmetic expressions.

The program also includes:
- **Infix → Postfix conversion** using the Shunting-Yard algorithm
- **Expression Tree Builder** to create composite objects
- **Service Layer** to orchestrate parsing and evaluation

---

## 🎯 Why Composite Design Pattern?

The **Composite Pattern** allows treating both individual objects (numbers) and compositions of objects (binary operations) uniformly.

### Structure in this project:
- **Component** → `Expression` (interface, common contract for evaluation)
- **Leaf** → `NumberExpression` (represents numbers)
- **Composite** → `BinaryExpression` (represents operations like `+`, `-`, `*`, `/`)

This makes the calculator:
- **Extensible**: New operations (e.g., power `^`, modulus `%`) can be added easily.
- **Consistent**: Whether it’s a single number or a complex nested expression, both can be evaluated using the same `evaluate()` method.

---

---

## ⚙️ How it Works

1. **User Input** → `(3 + 5) * 2`
2. **InfixToPostfixConverter** → converts infix → postfix
    - Output: `3 5 + 2 *`
3. **ExpressionTreeBuilder** → builds expression tree using postfix  
       (*)

      /      \

    (+)      2

   /     \\

   3       5

4. **Composite Pattern** → Evaluate recursively:
- `(3 + 5) = 8`
- `8 * 2 = 16`

---
## 🚀 Usage

### Run Demo

```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass="com.lld.calculator.CalculatorExpressionMain"