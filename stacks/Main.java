package stacks;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements: " + stack);

        // Popping an element from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after popping an element: " + stack);

        // Peeking at the top element of the stack
        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);
        System.out.println("Stack after peeking: " + stack);

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty);

        // Getting the size of the stack
        int size = stack.size();
        System.out.println("Size of the stack: " + size);
    }
}