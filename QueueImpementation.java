import java.util.*;

class QueueUsingStacks{
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStacks(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int data){
        stack1.push(data);
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
public class QueueImpementation {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.dequeue()); // 4
    }
}
