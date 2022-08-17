package lt.codeacademy.learn.project.entities;

import javax.persistence.*;

@Entity
//@Table(name="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String taskName;
	String taskStatus;
	String comment;
	
	public Task() {	}
	
	public Task(String taskName, String taskStatus, String comment) {
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", taskStatus=" + taskStatus + ", comment=" + comment
				+ "]";
	}

	
}
