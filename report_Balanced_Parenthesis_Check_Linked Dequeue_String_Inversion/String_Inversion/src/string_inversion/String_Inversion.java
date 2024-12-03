/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string_inversion;

import java.util.Scanner;


class Stack {
    private int top;
    private int capacity;
    private char[] array;

    public Stack(int capacity) {
        top = -1;
        this.capacity = capacity;
        this.array = new char[capacity];
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


class StringInverter {
    public static String invertString(String str) {
        Stack stack = new Stack(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuilder invertedString = new StringBuilder();
        while (!stack.isEmpty()) {
            invertedString.append(stack.pop());
        }

        return invertedString.toString();
    }
}


public class String_Inversion {
    public static void main(String[] args) {
        
        Stack mystack = new Stack(10);
        Scanner sc = new Scanner(System.in);
         
        System.out.print("Enter a string: ");
        String str = sc.next();

        String invertedString = StringInverter.invertString(str);
        System.out.println("The inverted string is: " + invertedString);
        
        
        
    
    }
}

 
