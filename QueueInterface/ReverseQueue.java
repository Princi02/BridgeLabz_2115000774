package QueueInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);
        
        reverseQueue(queue);
        
        System.out.println("Reversed Queue: " + queue);
    }

    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
