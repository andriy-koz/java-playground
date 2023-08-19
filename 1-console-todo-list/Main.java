import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task\n2. Remove Task\n3. Mark Task as Done\n4. Display All Tasks\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    // logic for adding a task
                    System.out.println("Enter the title of the task:");
                    String title = scanner.nextLine();

                    System.out.println("Enter the description of the task:");
                    String description = scanner.nextLine();

                    Task newTask = new Task(title, description);
                    todoList.addTask(newTask);
                    break;
                case 2:
                    // logic for removing a task
                    System.out.println("Enter the title of the task you want to remove:");
                    title = scanner.nextLine();

                    Task taskToRemove = null;
                    for (Task task : todoList.getAllTasks()) {
                        if (task.getTitle().equals(title)) {
                            taskToRemove = task;
                            break;
                        }
                    }

                    if (taskToRemove != null) {
                        todoList.removeTask(taskToRemove);
                        System.out.println("Task removed successfully!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    // logic for marking task as done
                    System.out.println("Enter the title of the task you want to mark as done:");
                    title = scanner.nextLine();

                    boolean found = false;
                    for (Task task : todoList.getAllTasks()) {
                        if (task.getTitle().equals(title)) {
                            task.markAsDone();
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    // logic for displaying all tasks
                    System.out.println("Taks:");
                    for (Task task : todoList.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }
}