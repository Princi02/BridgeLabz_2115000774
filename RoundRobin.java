import java.util.*;

class Process {
    int id, burstTime, priority, waitingTime, turnAroundTime;
    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head, tail;

    void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
            return;
        }
        tail.next = newProcess;
        newProcess.next = head;
        tail = newProcess;
    }

    void executeProcesses(int timeQuantum) {
        if (head == null) return;
        int totalProcesses = 0, totalWaitingTime = 0, totalTurnAroundTime = 0;
        Process temp = head;

        while (true) {
            boolean done = true;
            Process current = head;

            do {
                if (current.burstTime > 0) {
                    done = false;
                    int executionTime = Math.min(timeQuantum, current.burstTime);
                    current.burstTime -= executionTime;
                    totalProcesses++;

                    if (current.burstTime == 0) {
                        current.turnAroundTime = totalProcesses * timeQuantum;
                        current.waitingTime = current.turnAroundTime - executionTime;
                        totalWaitingTime += current.waitingTime;
                        totalTurnAroundTime += current.turnAroundTime;
                        removeProcess(current.id);
                    }
                }
                current = current.next;
            } while (current != head);

            if (done) break;
        }

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) totalProcesses));
    }

    void removeProcess(int id) {
        if (head == null) return;
        Process temp = head, prev = null;

        while (temp.id != id) {
            prev = temp;
            temp = temp.next;
            if (temp == head) return;
        }

        if (temp == head && temp.next == head) {
            head = null;
            return;
        }

        if (temp == head) {
            tail.next = head.next;
            head = head.next;
        } else if (temp == tail) {
            prev.next = head;
            tail = prev;
        } else {
            prev.next = temp.next;
        }
    }

    void displayProcesses() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println(temp.id + " | Burst: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);
        scheduler.displayProcesses();
        scheduler.executeProcesses(4);
    }
}
