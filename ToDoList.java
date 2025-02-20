import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {
    public static void main(String[] args) {
        
        ArrayList<Task> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true) {

        System.out.print("\033[H\033[2J");
        System.out.println("1. Create New Task\n2. List Of Task\n3. Complit Task\n4. Delete Task");

        int Choose = sc.nextInt();

        TaskType Type = TaskType.JOB;
        Task task;

        if(Choose == 1) {
            System.out.print("\033[H\033[2J");
            System.out.println("1. JOB\n2. SCHOOL\n3. PERSONAL");
            System.out.print("Type : ");
            int TypeInt = sc.nextInt();

            switch (TypeInt) {
            case 1 -> Type = TaskType.JOB;
            case 2 -> Type = TaskType.SCHOOL;
            case 3 -> Type = TaskType.PERSONAL;
            }
        
            Scanner scan = new Scanner(System.in);

            System.out.print("\033[H\033[2J");
            System.out.print("Desciption : ");
            String Desciption = scan.nextLine();

            task = new Task(Type, Desciption, false);

            list.add(task);

        } else if(Choose == 2) {

            System.out.print("\033[H\033[2J");

            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }

            System.out.print("1. Quit ");
            int TypeInt = sc.nextInt();

        } else if(Choose == 3) {

            System.out.print("\033[H\033[2J");

            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getDo() == false) {
                    System.out.print(i + ". ");
                    System.out.println(list.get(i).toString() + "\n");
                }
            }
            System.out.print("1. Delete \n2. Quit ");
            int TypeInt = sc.nextInt();

            if(TypeInt == 1) {
                System.out.print("\033[H\033[2J");
                System.out.print("Task Number : ");
                int TaskNumber = sc.nextInt();
                if (TaskNumber >= 0 && TaskNumber < list.size()) {
                        list.remove(TaskNumber);
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } else if (TypeInt == 2) {
                    continue;
                }

        }
        }

    }
}
