class Task{
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}




class TaskScheduler{
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;


    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(head == null){
            head = tail = newTask;
            newTask.next = head;
            head = newTask;
        }
        else{
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }


    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(head == null){
            head = tail = newTask;
            newTask.next = head;
        }
        else{
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }


    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(position <= 1 || head == null){
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task temp = head;
        for(int i = 1; i < position - 1 && temp.next != head; i++){
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if(temp == tail){
            tail = newTask;
        }
    }

    public void removeTaskById(int taskId){
        if(head == null){
            System.out.println("Task list is empty.");
            return;
        }

        Task temp = head, prev = null;

        if (head.taskId == taskId) {
            if (head == tail) { // Only one node
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Task " + taskId + " removed.");
            return;
        }

        while(temp.next != head){
            if(temp.next.taskId == taskId){
                temp.next = temp.next.next;
                if(tail.taskId == taskId){
                    tail = temp;
                }
                System.out.println("Task " + taskId + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task ID " + taskId + " not found.");
    }


    public void viewAndMoveToNextTask(){
        if(head == null){
            System.out.println("No tasks available.");
            return;
        }
        if (currentTask == null) {
            currentTask = head;
        }
        System.out.println("Current Task: " + currentTask.taskName + " (ID: " + currentTask.taskId + ")");
        currentTask = currentTask.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found - ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }


    
}


public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks at different positions
        scheduler.addTaskAtBeginning(1, "Task A", 2, "2025-02-15");
        scheduler.addTaskAtEnd(2, "Task B", 1, "2025-02-16");
        scheduler.addTaskAtPosition(3, "Task C", 3, "2025-02-17", 2);

        // Display all tasks
        System.out.println("\nAll Tasks:");
        scheduler.displayAllTasks();

        // Remove a task
        System.out.println("\nRemoving Task with ID 2...");
        scheduler.removeTaskById(2);

        // Display tasks after removal
        System.out.println("\nTasks After Removal:");
        scheduler.displayAllTasks();

        // Viewing and moving to next task
        System.out.println("\nViewing and Moving Through Tasks:");
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        // Searching for a task by priority
        System.out.println("\nSearching for Tasks with Priority 3:");
        scheduler.searchTaskByPriority(3);
    }
}
