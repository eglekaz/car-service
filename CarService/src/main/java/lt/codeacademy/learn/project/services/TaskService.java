package lt.codeacademy.learn.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.learn.project.entities.Task;
import lt.codeacademy.learn.project.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public Task save (Task task) {
		return taskRepository.save(task);
	}
	
	public Task findById (int id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
		return task;
	}
	
	public void delete (Task task) {
		taskRepository.delete(task);
	}
}
