package org.snhu.cs320.task;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    // Add a new task (must have a unique ID)
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists: " + task.getTaskId());
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete a task by ID
    public void deleteTask(String taskId) {
        if (tasks.remove(taskId) == null) {
            throw new NoSuchElementException("Task ID not found: " + taskId);
        }
    }

    // Update task name by ID
    public void updateTaskName(String taskId, String newName) {
        Task task = getTask(taskId);
        task.setTaskName(newName);
    }

    // Update task description by ID
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = getTask(taskId);
        task.setTaskDescription(newDescription);
    }

    // Helper: retrieve a task or throw error if not found
    private Task getTask(String taskId) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new NoSuchElementException("Task ID not found: " + taskId);
        }
        return task;
    }

    // Optional: for testing convenience
    public int getTaskCount() {
        return tasks.size();
    }
}