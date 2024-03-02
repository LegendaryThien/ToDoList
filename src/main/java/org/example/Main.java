package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = input.nextLine();
                    todoList.addTask(description);
                    todoList.displayTasks();
                    break;
                case 2:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = input.nextInt() - 1;
                    todoList.removeTask(removeIndex);
                    todoList.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = input.nextInt() - 1;
                    todoList.markTaskAsCompleted(completeIndex);
                    todoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Tasks:");
                    todoList.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markAsCompleted();
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.addTask("Buy groceries");
        todoList.addTask("Finish homework");
        todoList.addTask("Go for a run");

        todoList.displayTasks();

        todoList.markTaskAsCompleted(1);
        todoList.removeTask(2);

        System.out.println("Updated Task List:");
        todoList.displayTasks();
    }
}

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // By default, tasks are not completed
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}
