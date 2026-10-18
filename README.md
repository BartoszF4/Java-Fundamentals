# Java Fundamentals

This repository contains laboratory exercises and projects developed during the 3rd-semester Java Fundamentals course. The tasks demonstrate core Java concepts, including strict type parsing, exception handling, string manipulation, and object-oriented design principles.

## Repository Structure

### 📁 [Task 01 - Quadratic Equation](./Task-01-Quadratic-Equation)
A command-line utility that calculates the roots of a quadratic equation ($ax^2 + bx + c = 0$)[cite: 80].
* **Command-line parsing**: Reads coefficients directly from the invocation arguments[cite: 80].
* **Exception Handling**: Safely catches `NumberFormatException` to validate integer inputs before processing[cite: 81, 82].
* **Edge Case Management**: Includes conditional logic to handle scenarios where $a = 0$ (linear equations or infinite/no solutions) and calculates the delta for real roots extraction[cite: 82].

### 📁 [Task 02 - String Operations](./Task-02-String-Operations)
A program designed to safely manipulate strings based on index parameters provided via the command line[cite: 80].
* **Substring Extraction**: Extracts a specific section of a string from an inclusive start index to an exclusive end index, and reconstructs the remaining string without the extracted part[cite: 80, 81].
* **Strict Input Validation**: Implements extensive bounds checking to prevent negative indices, inverted bounds ($b \le a$), or out-of-bounds exceptions relative to the string length[cite: 81].

---

## Compilation & Execution
Navigate to the specific task directory and use the standard Java compiler (`javac`) and runtime (`java`). For example:

```bash
javac Substring.java
java Substring "Welcome" 1 4
