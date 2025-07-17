/**
 * @author Anoushka Poojary
 * CMSC 256 - Intro to Data Structures Section 901
 * Project 6 - Arithmetic Expression Parse Tree Implementation
 * @version 04/11/2025
 * This project involves the implementation of trees by building arithmetic expressions and using stacks to build such
 * trees. It also implements an inner Binary Node class to set up and traverse through the tree.
 */
package cmsc256;

import java.util.Stack;

public class Project6 {

    /**
     * This method builds a parse tree from an expression.
     * @param expression an arithmetic expression
     * @return Root node of the tree
     * @throws IllegalArgumentException if fully parenthesized mathematical expression is not present or parenthesis are
     * unbalanced
     */
    public static BinaryNode<String> buildParseTree(String expression) {
        //Split the expression into a String array based on the space
        String[] expressionArray = expression.split(" ");

        //Create a stack
        Stack<BinaryNode<String>> stack = new Stack<>();

        //Create a new node and push that node on top of the stack
        BinaryNode<String> currentNode = new BinaryNode<>("");
        stack.push(currentNode);

        //Iterate through each element of the expression
        for (String character : expressionArray) {
            //Create a left child node for opening parenthesis
            if (character.equals("(")) {
                BinaryNode<String> leftChild = new BinaryNode<>("");
                currentNode.setLeft(leftChild);
                stack.push(currentNode);
                currentNode = leftChild;
            }
            //If the character is an operator, set the node value and create a right child
            else if (character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/")) {
                currentNode.setValue(character);
                BinaryNode<String> rightChild = new BinaryNode<>("");
                currentNode.setRight(rightChild);
                stack.push(currentNode);
                currentNode = rightChild;
            }
            //If the character is a closing parenthesis, pop back the current node
            //Exception is thrown when there are extra closing parenthesis
            else if (character.equals(")")) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Too many closing parentheses.");
                }
                currentNode = stack.pop();
            }
            //Set a number and then return to the parent node
            else {
                currentNode.setValue(character);
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Missing closing parentheses.");
                }
                currentNode = stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Unbalanced parentheses");
        }

        return currentNode;
    }

    /**
     * Evaluates problem based on the binary tree
     * @param tree the expression represented by a binary tree
     * @return numeric solution to the problem
     * @param <E> Generic type so that IntelliJ does not get mad at me
     * @throws IllegalArgumentException if it is not a numeric value
     */
    public static <E> double evaluate(BinaryNode<E> tree) {
        //Base case: If the node is a leaf, return a numeric value
        if (tree.getLeft() == null && tree.getRight() == null) {
            try {
                return Double.parseDouble(tree.getValue().toString());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid operand");
            }
        }

        //Recursive step that moves the function toward the base case is to call
        //Evaluation both the left and the right children of the current node.
        double leftVal = evaluate(tree.getLeft());
        double rightVal = evaluate(tree.getRight());

        //Get the operator
        String operator = tree.getValue().toString();

        //Results of the two recursive calls and using the operator
        switch (operator) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    /**
     * This method recovers the original infix mathematical expression from a parse tree.
     * @param tree the expression represented by a binary tree
     * @return infix expression
     * @param <E> Generic type so that IntelliJ does not get mad at me
     */
    public static <E> String getInfixExpression(BinaryNode<E> tree) {
        //If the node is a leaf, return the value
        if (tree.getLeft() == null && tree.getRight() == null) {
            return (String) tree.getValue();
        }

        //Recursive step to get the left and right children of the node
        String leftExpression = getInfixExpression(tree.getLeft());
        String rightExpression = getInfixExpression(tree.getRight());

        //Return the infix expression
        return "( " + leftExpression + " " + tree.getValue() + " " + rightExpression + " )";
    }


    public static class BinaryNode<E> {
        E data;
        BinaryNode<E> left;
        BinaryNode<E> right;

        // Constructor
        public BinaryNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        //Getter and setters
        public E getValue() {
            return data;
        }

        public void setValue(E data) {
            this.data = data;
        }

        public BinaryNode<E> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<E> left) {
            this.left = left;
        }

        public BinaryNode<E> getRight() {
            return right;
        }

        public void setRight(BinaryNode<E> right) {
            this.right = right;
        }
    }

}
