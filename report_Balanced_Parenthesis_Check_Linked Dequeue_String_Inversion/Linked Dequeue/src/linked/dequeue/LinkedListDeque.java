/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.dequeue;

/**
 *
 * @author wwwse
 */

public class LinkedListDeque {
private Node front;
private Node rear;
private int size;


public void create() {
front = null;
rear = null;
size = 0;
}


public void insertFront(int value) {
Node newNode = new Node(value);
if (isEmpty()== 1) {
    front = newNode;
    rear = newNode;
} 
else {
    newNode.next = front;
    front = newNode;
     }

size++;

}


public void insertRear(int value) {
Node newNode = new Node(value);
if (isEmpty()== 1) {
    front = newNode;
    rear = newNode;
} 
else {
    rear.next = newNode;
    rear = newNode;
}

size++;

}


public int removeFront() {
if (isEmpty() == 1) {
    return -1; 
}
int value = front.data;
front = front.next;
size--;
return value;
}


public int removeRear() {
if (isEmpty() == 1) {
return -1; // Dequeue is empty
}
int value = rear.data;
Node current = front;
while (current.next != rear) {
current = current.next;
}
current.next = null;
rear = current;
size--;
return value;
}


public int size() {
return size;
}


public int isEmpty() {
if (size == 0)
return 1 ;
else 
return 0 ;
}


public int getFirstPosition(int value) {
Node current = front;
int position = 1;
while (current != null) {
    if (current.data == value) {
        return position;
}
current = current.next;
position++;
}

return -1; 

}


public int getLastPosition(int value) {
Node current = front;
int position = 1;
int found = -1;
while (current != null) {
    if (current.data == value) {
        found = position;
}
current = current.next;
position++;
}

return found;

}


public int getCount(int value) {
Node current = front;
int count = 0;
while (current != null) {
    if (current.data == value) {
        count++;
    }
    current = current.next;
}
return count;
}


public int getMin() {
if (isEmpty() == 1) {
return -1; 
}
Node current = front;
int min = current.data;
while (current != null) {
    if (current.data < min) {
        min = current.data;
    }
current = current.next;
}

return min;

}


public int getMax() {
if (isEmpty() == 1) {
return -1; 
}
Node current = front;
int max = current.data;
while (current != null) {
    if (current.data > max) {
        max = current.data;
}
current = current.next;
}

return max;

}

   
public int getKth(int k) {
if (k < 1 || k > size) {
    return -1; 
}
Node current = front;
for (int i = 1; i < k; i++) {
current = current.next;
}

return current.data;

}


public int linearSearch(int value) {
Node current = front;
int position = -1;
int currentPosition = 1;
while (current != null) {
if (current.data == value) {
position = currentPosition;
}
current = current.next;
currentPosition++;
}

return position;

}


public void printForwards() {
Node current = front;
while (current != null) {
System.out.print(current.data + " ");
current = current.next;
}
System.out.println();
}


public void printBackwards() {
        printBackwardsHelper(front);
        System.out.println();
}

private void printBackwardsHelper(Node current) { 
if (current == null) {
    return;
}
printBackwardsHelper(current.next);
System.out.print(current.data + " ");
}


public void deleteKth(int k) {
if (k < 1 || k > size) {
    return; 
}
if (k == 1) {
front = front.next;
} 
else {
Node current = front;
for (int i = 1; i < k - 1; i++) {
    current = current.next;
}
current.next = current.next.next;
if (k == size) {
    rear = current;
}
}

size--;

}

public static void main(String[] args) {

LinkedListDeque Dequeue = new LinkedListDeque(); 

Dequeue.create();
Dequeue.insertFront(1);
Dequeue.insertFront(2);        
Dequeue.insertFront(5);        
Dequeue.insertRear(2);
Dequeue.insertRear(1);
Dequeue.insertRear(4);
System.out.println(Dequeue.size());
System.out.println(Dequeue.isEmpty());
System.out.println(Dequeue.getFirstPosition(1));
System.out.println(Dequeue.getLastPosition(1));
System.out.println(Dequeue.getCount(2));
System.out.println(Dequeue.getCount(5));
System.out.println(Dequeue.getCount(18));
System.out.println(Dequeue.getMin());
System.out.println(Dequeue.getMax());
System.out.println(Dequeue.getKth(3));
System.out.println(Dequeue.getKth(4));
System.out.println(Dequeue.getKth(1));
System.out.println(Dequeue.getKth(6));
System.out.println(Dequeue.getKth(7));
System.out.println(Dequeue.getKth(0));
System.out.println(Dequeue.linearSearch(2));
Dequeue.printForwards();
Dequeue.printBackwards();
Dequeue.deleteKth(4);
System.out.println(Dequeue.getCount(2));
System.out.println(Dequeue.getKth(4));
System.out.println(Dequeue.getFirstPosition(1));
System.out.println(Dequeue.getLastPosition(1));
System.out.println(Dequeue.linearSearch(2));
Dequeue.printForwards();
Dequeue.printBackwards();



    }
}

