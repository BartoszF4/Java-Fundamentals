# Java Fundamentals

This repository contains laboratory exercises and projects developed during the 3rd-semester Java Fundamentals course. The tasks demonstrate core Java concepts, including strict type parsing, exception handling, string manipulation, and object-oriented design principles.

## Repository Structure

### 📁 [Task 01 - Quadratic Equation](./Task-01-Quadratic-Equation)
A command-line utility that calculates the roots of a quadratic equation (ax^2 + bx + c = 0).
* **Command-line parsing**: Reads coefficients directly from the invocation arguments.
* **Exception Handling**: Safely catches `NumberFormatException` to validate integer inputs before processing.
* **Edge Case Management**: Includes conditional logic to handle scenarios where a = 0 (linear equations or infinite/no solutions) and calculates the delta for real roots extraction.

### 📁 [Task 02 - String Operations](./Task-02-String-Operations)
A program designed to safely manipulate strings based on index parameters provided via the command line.
* **Substring Extraction**: Extracts a specific section of a string from an inclusive start index to an exclusive end index, and reconstructs the remaining string without the extracted part.
* **Strict Input Validation**: Implements extensive bounds checking to prevent negative indices, inverted bounds (b <= a), or out-of-bounds exceptions relative to the string length.

### 📁 [Task 03 - Loops](./Task-03-Loops)
A console-based number guessing game where the user attempts to find a randomly generated integer between 0 and 100.
* **Random Generation**: Utilizes `java.util.Random` to determine the target number.
* **Input Validation**: Uses `java.util.Scanner` with `hasNextInt()` to elegantly handle invalid non-integer inputs without crashing the program.
* **Game Loop**: Features a main `do-while` loop for replayability and an inner `while` loop for continuous guessing with higher/lower feedback.

### 📁 [Task 04 - Regular Expressions](./Task-04-Regular-Expressions)
A utility that validates arithmetic expressions by checking character validity and parenthesis nesting.
* **Character Validation**: Uses `java.util.regex` to ensure the string contains only valid numbers, mathematical operators, and parentheses[cite: 85].
* **Parenthesis Matching**: Implements an algorithmic depth-counting method (`isBalanced`) to verify arbitrarily nested parentheses, addressing the theoretical limitation of regular expressions for recursive structures[cite: 85].

---

## Compilation & Execution
Navigate to the specific task directory and use the standard Java compiler (`javac`) and runtime (`java`). For example:

```bash
javac Substring.java
java Substring "Welcome" 1 4
