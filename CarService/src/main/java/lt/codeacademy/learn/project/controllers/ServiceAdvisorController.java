package lt.codeacademy.learn.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.entities.Task;
import lt.codeacademy.learn.project.services.CarService;
import lt.codeacademy.learn.project.services.TaskService;

@Controller
@RequestMapping("/service-advisor")
public class ServiceAdvisorController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	CarService carService;
	
	@GetMapping("/all")
    public String showAllCars(Model model) {
		model.addAttribute("cars", carService.getAll());
        return "serviceAdvisor/car-list";
	}
	
	@GetMapping("/view/{id}")
	public String showCar (@PathVariable("id") int id, Model model) {
		Car car = carService.findById(id);
		model.addAttribute("car", car);
		return "serviceAdvisor/car";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCar (@PathVariable("id") int id, Model model) {
		Car car = carService.findById(id);
		carService.delete(car);
		return "redirect:/service-advisor/all";
	}
	
	@PostMapping("/save")
	public String saveCar (Car car) {
		carService.save(car);
		return "redirect:/service-advisor/all";
	}
	
	@PostMapping("/updateCar/{id}")
	public String updateCar(@PathVariable("id") int id, Car car, Model model) {
		carService.save(car);
		return "redirect:/service-advisor/view/" + car.getId();
	}
	
	@GetMapping("/editTask/{id}")
	public String editCar(@PathVariable("id") int id, Model model) {
		Task task = taskService.findById(id);
		model.addAttribute("task", task);
		return "serviceAdvisor/edit-task";
	}
	
	@PostMapping("/updateTask/{id}")
	public String updateTask(@PathVariable("id") int id, Task task, Model model) {
		taskService.save(task);
		return "redirect:/service-advisor/view/" + task.getCar().getId();
	}
	
	@GetMapping("/addTask/{id}")
    public String showCreateTaskForm(@PathVariable("id") int id, Task task, Model model) {
		Car car = carService.findById(id);
		model.addAttribute("car", car);
		
        return "serviceAdvisor/add-task";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask (@PathVariable("id") int id, Model model) {
		Task task = taskService.findById(id);
		taskService.delete(task);
		return "redirect:/service-advisor/view/" + task.getCar().getId();
	}
	
	@PostMapping("/saveTask/{id}")
	public String saveTask (@PathVariable("id") int id, Task task) {
		Car car = carService.findById(id);
		task.setCar(car);
		taskService.save(task);
		return "redirect:/service-advisor/view/" + id;
	}
	
	@GetMapping("/add")
    public String showCreateForm(Car car) {
        return "serviceAdvisor/add-car";
	}
	

//	
//	@PostMapping("/saveJson")
//	public String saveCarJson (@RequestBody Car car) {
//		carService.save(car);
//		return "redirect:/index";
//	}
//	
//	@GetMapping("/getDummyCar")
//	public @ResponseBody Car getDummyCar() {
//		Car car = new Car ("ABC123", "Audi", 2009, "Jonas", 860051211, "Headlights do not work");
//		car.addTask(new Task ("diagnostics", "Done", ""));
//		car.addTask(new Task ("changing bulb", "In Progress", ""));
//		return car;
//	}
//	
//	@GetMapping("/getDummy")
//	public @ResponseBody Task getDummy() {
//		return new Task ("taskname", "taskstatus", "taskcomment");
//	}
//	
//	@PostMapping("/saveTaskJson")
//	public String saveTaskJson (@RequestBody Task task) {
//		taskService.save(task);
//		return "redirect:/index";
//	}

}
