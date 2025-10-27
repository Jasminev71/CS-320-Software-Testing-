package org.snhu.cs320.task;

public class Task {
	
	  private final String taskId; // this will not allow the id to be updated
	    private String taskName;
	    private String taskDescription;

	    public Task(String taskId, String taskName, String taskDescription) {
	        this.taskId = validateId(taskId);
	        this.taskName = validateName(taskName);
	        this.taskDescription = validateDescription(taskDescription);
	    }

	    // Getters
	    public String getTaskId() { return taskId; }
	    public String getTaskName() { return taskName; }
	    public String getTaskDescription() { return taskDescription; }

	    // Setters 
	    public void setTaskName(String taskName) {
	        this.taskName = validateName(taskName);
	    }

	    public void setTaskDescription(String taskDescription) {
	        this.taskDescription = validateDescription(taskDescription);
	    }

	    // Validation
	    private static String validateId(String id) {
	        if (id == null || id.trim().isEmpty() || id.length() > 10) {
	            throw new IllegalArgumentException("taskId must be 1–10 characters.");
	        }
	        return id.trim();
	    }

	    private static String validateName(String name) {
	        if (name == null || name.trim().isEmpty() || name.length() > 20) {
	            throw new IllegalArgumentException("taskName must be 1–20 characters.");
	        }
	        return name.trim();
	    }

	    private static String validateDescription(String description) {
	        if (description == null || description.trim().isEmpty() || description.length() > 50) {
	            throw new IllegalArgumentException("taskDescription must be 1–50 characters.");
	        }
	        return description.trim();
	    }
	}


