import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {
    private static ArrayList<Task> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.println("1. Create New Task\n2. List Of Task\n3. Complete Task\n4. Delete Task");

            int choose = sc.nextInt();

            switch (choose) {
                case 1 -> createTask();
                case 2 -> listTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createTask() {
        System.out.print("\033[H\033[2J");
        System.out.println("1. JOB\n2. SCHOOL\n3. PERSONAL");
        System.out.print("Type : ");
        int typeInt = sc.nextInt();
        TaskType type = switch (typeInt) {
            case 1 -> TaskType.JOB;
            case 2 -> TaskType.SCHOOL;
            case 3 -> TaskType.PERSONAL;
            default -> TaskType.PERSONAL;
        };

        sc.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.print("Description : ");
        String description = sc.nextLine();

        Task task = new Task(type, description, false);
        list.add(task);
    }

    private static void listTasks() {
        justListTasks();
        System.out.print("\n1. Quit ");
        sc.nextInt();
    }

    private static void completeTask() {
        justListTasksDo();
        System.out.print("1. Do \n2. Quit ");
        int typeInt = sc.nextInt();

        if (typeInt == 1) {
            System.out.print("\033[H\033[2J");
            justListTasksDo();
            System.out.print("Task Number : ");
            int taskNumber = sc.nextInt();
            if (taskNumber >= 0 && taskNumber < list.size()) {
                list.get(taskNumber).Do = true;
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void deleteTask() {
        justListTasks();
        System.out.print("1. Delete \n2. Quit ");
        int typeInt = sc.nextInt();

        if (typeInt == 1) {
            System.out.print("\033[H\033[2J");
            justListTasks();
            System.out.print("Task Number : ");
            int taskNumber = sc.nextInt();
            if (taskNumber >= 0 && taskNumber < list.size()) {
                list.remove(taskNumber);
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void justListTasks () {
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ". ");
            System.out.println(list.get(i).toString() + "\n");
        }
    }

    private static void justListTasksDo () {
        System.out.print("\033[H\033[2J");
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getDo()) {
                System.out.print(i + ". ");
                System.out.println(list.get(i).toString() + "\n");
            }
        }
    }
}