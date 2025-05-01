import java.util.Scanner;

/**
 * Implementation of a Stack using a linked list data structure
 */
public class StackLinkedList {
    private Node top; // Reference to the top node of the stack

    /**
     * Node class representing each element in the linked list
     * Contains the data and a reference to the next node
     */
    private class Node {
        String data;  // Stores the String data for this node
        Node next;    // Reference to the next node in the list

        /**
         * Constructor for creating a new node
         * @param data The data to be stored in the node
         * Initializes next pointer to null
         */
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Pushes a new element onto the top of the stack
     * Creates new node, links it to current top, and updates top reference
     * @param data The data to be pushed onto the stack
     */
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = top;      // Link new node to current top
        top = newNode;           // Update top reference
    }

    /**
     * Removes and returns the top element from the stack
     * Updates top reference to next node
     * @return The data from the top element
     * @throws IllegalStateException if the stack is empty
     */
    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The Stack is empty");
        }
        String data = top.data;  // Get data from top node
        top = top.next;         // Move top reference to next node
        return data;
    }

    /**
     * Checks if the stack is empty
     * Stack is empty when top reference is null
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the current size of the stack
     * Traverses the entire list counting nodes
     * @return Number of elements in the stack
     */
    public int size() {
        int count = 0;
        Node current = top;
        while (current != null) {  // Traverse until end of list
            count++;
            current = current.next;
        }
        return count;
    }
}

/**
 * Class that handles postfix expression operations
 * Implements a postfix calculator using a stack
 */
class PostfixOperations {
    private StackLinkedList stack; // Stack to store operands and results

    /**
     * Constructor initializes a new stack
     * Creates empty stack for storing operands
     */
    public PostfixOperations() {
        this.stack = new StackLinkedList();
    }

    /**
     * Processes input string as either number or operator
     * Handles numeric inputs, operators, and invalid inputs
     * @param input The input string to process
     */
    public void processInput(String input) {
        if (isNumeric(input)) {
            stack.push(input);
            System.out.println("Pushed number: " + input);
            System.out.println("");
        } else if (isValidOperator(input)) {
            processOperator(input);
        } else {
            System.out.println("Invalid input '" + input);
            System.out.println("The input must be a number, an operator (+,-,*,/), or R to see the result.");
        }
    }

    /**
     * Checks if a string can be parsed as a number
     * Handles null, empty strings and number format validation
     * @param str The string to check
     * @return true if string is numeric, false otherwise
     */
    public boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates if string is a valid operator
     * Checks if input is one of: +, -, *, /
     * @param str The string to check
     * @return true if string is valid operator, false otherwise
     */
    public boolean isValidOperator(String str) {
        if (str == null) {
            return false;
        }
        return "+-*/".contains(str);
    }

    /**
     * Processes an operator by performing the operation on top two stack elements
     * Pops two operands, performs operation, pushes result back to stack
     * @param operator The operator to process
     */
    private void processOperator(String operator) {

        if (stack.size() < 2) {
            System.out.println("Error: Not enough operands for " + operator);
            return;
        }
        try {
            // Pop operands in reverse order
            String op2 = stack.pop();
            String op1 = stack.pop();

            double num1 = Double.parseDouble(op1);
            double num2 = Double.parseDouble(op2);

            double result = performOperation(num1, num2, operator);
            stack.push(String.valueOf(result));
            System.out.println("Performed " + num1 + " " + operator + " " + num2 + " = " + result);
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error performing operation: " + e.getMessage());
        }
    }

    /**
     * Performs arithmetic operation based on operator
     * Handles basic arithmetic operations and error cases
     * @param num1 First operand
     * @param num2 Second operand
     * @param operator The operator to apply
     * @return Result of the operation
     * @throws ArithmeticException if division by zero
     * @throws IllegalArgumentException if invalid operator
     */
    private double performOperation(double num1, double num2, String operator) {
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    /**
     * Returns the final result from the stack
     * Pops and returns top value or error if stack empty
     * @return String containing the result or error message if stack is empty
     */
    public String getResult() {
        if (stack.isEmpty()) {
            return "The Stack is empty";
        } else {
            return "The end result of the expression is: " + stack.pop();
        }
    }
}

/**
 * Main class that runs the postfix calculator
 * Handles user input and calculator operation
 */
class PostfixCalculatorMain {
    public static void main(String[] args) {
        PostfixOperations calculator = new PostfixOperations();
        Scanner keyboard = new Scanner(System.in);

        // Print instructions for user
        System.out.println("Enter the postfix expression one character at a time for evaluation.");
        System.out.println("When done, enter R to see the results.");
        System.out.println("");

        try {
            while (true) {
                System.out.println("Enter a character, or enter R to see the result: ");
                String input = keyboard.nextLine().trim();

                if (input.equalsIgnoreCase("R")) {
                    System.out.println("Final result: " + calculator.getResult());
                    break;
                }
                calculator.processInput(input);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        keyboard.close();
    }
}
