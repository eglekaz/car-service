package lt.codeacademy.learn.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.entities.Task;

@DataJpaTest
class TaskRepositoryTest {

	@Autowired
	TaskRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	@Test
	void testSave() {
		Task task = new Task (
				"ABC123", 
				"Audi",
				""
		);
		
		// when
		underTest.save(task);
		
		// then
		assertThat(underTest.count()>0);
				
	}

	@Test
	void itShouldFindTaskById() {
		// given
		int taskId = 2;
		Task task = new Task (
				"ABC123", 
				"Audi",
				""
		);
		underTest.save(task);
		
		// when
		Task expectedTask = underTest.findById(taskId).get();
		
		// then
		assertThat(expectedTask.equals(task));
	}

	@Test
	void testDeleteById() {
		// given
		int taskId = 3;
		Task task = new Task (
				"ABC123", 
				"Audi",
				""
		);
		underTest.save(task);
		
		// when
		underTest.deleteById(taskId);
		
		// then
		assertThat(underTest.count()==0);
	}

}
