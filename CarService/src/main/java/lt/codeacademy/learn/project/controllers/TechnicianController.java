package lt.codeacademy.learn.project.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.entities.Task;
import lt.codeacademy.learn.project.services.CarService;
import lt.codeacademy.learn.project.services.TaskService;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	CarService carService;
	
	@GetMapping("/all")
    public String showAllCars(Model model) {
		model.addAttribute("cars", carService.getAll());
        return "technician/car-list";
	}
	
	@GetMapping("/view/{id}")
	public String showCar (@PathVariable("id") int id, Model model) {
		Car car = carService.findById(id);
		model.addAttribute("car", car);
		return "technician/car";
	}
	
	@GetMapping("/editTask/{id}")
	public String editCar(@PathVariable("id") int id, Model model) {
		Task task = taskService.findById(id);
		model.addAttribute("task", task);
		return "technician/edit-task";
	}
	
	@PostMapping("/updateTask/{id}")
	public String updateTask(@PathVariable("id") int id, Task task, Model model) {
		taskService.save(task);
		return "redirect:/technician/view/" + task.getCar().getId();
	}
	
}