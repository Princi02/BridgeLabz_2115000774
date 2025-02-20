package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        int topElement = queue1.remove();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        int topElement = queue1.peek(); 
        queue2.add(queue1.remove()); 

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element: " + stack.top()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Top element after pop: " + stack.top()); 
        
        stack.push(4);
        System.out.println("Top element after push: " + stack.top()); 
    }
}

