/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanced_parenthesis_check;

import java.util.Scanner;


class Stack {
    private int top;
    private int capacity;
    private char[] array;

    public Stack(int capacity) {
        top = -1;
        this.capacity = capacity;
        array = new char[capacity];
    }

    public void push(char element) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        array[top] = element;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return ' ';
        }
        char element = array[top];
        top--;
        return element;
    }

    public int peek(){
    return array[top];
    
    }
        
    public boolean isEmpty() {
    return (top == -1);
    }

    public boolean isFull() {
    return (top == capacity - 1);
    }

    public void print(){
    for(int i =0;i<=top;i++)     
       System.out.println(array[i]+ " ");
    System.out.println();    
    }

}


public class Balanced_Parenthesis_Check {
    public static boolean isBalanced(String str) {
        Stack s = new Stack(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                char top = s.pop();
                if (c == ')' && top != '(') {
                    return false;
                } else if (c == ']' && top != '[') {
                    return false;
                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of parentheses: ");
        String str = scanner.next();
        if (isBalanced(str)) {
            System.out.println("The parentheses are balanced");
        } else {
            System.out.println("The parentheses are not balanced");
        }
    }
}

