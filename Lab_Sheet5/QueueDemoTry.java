package Lab_Sheet5;

interface QueueImpl {
    void insert(int value) throws Exception;
    int delete() throws Exception;
    void display();
}

class QueueDemo implements QueueImpl {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueDemo() {
        queue = new int[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void insert(int value) throws Exception {
        if (size == queue.length) {
            throw new Exception("Queue Overflow: Cannot insert, queue is full!");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    @Override
    public int delete() throws Exception {
        if (size == 0) {
            throw new Exception("Queue Underflow: Cannot delete, queue is empty!");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    @Override
    public void display() {
        if (size == 0) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.print("Current queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }
}

public class QueueDemoTry {
    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n--- Queue Operations ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter an integer to insert: ");
                        int value = scanner.nextInt();
                        queue.insert(value);
                        System.out.println(value + " inserted into the queue.");
                        break;
                    case 2:
                        int deletedValue = queue.delete();
                        System.out.println("Deleted " + deletedValue + " from the queue.");
                        break;
                    case 3:
                        queue.display();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
