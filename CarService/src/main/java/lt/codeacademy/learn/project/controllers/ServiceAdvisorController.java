package lt.codeacademy.learn.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping("/saveJson")
	public String saveCarJson (@RequestBody Car car) {
		carService.save(car);
		return "redirect:/index";
	}
	
	@PostMapping("/save")
	public String saveCar (Car car) {
		carService.save(car);
		return "redirect:/service-advisor/all";
	}
	
	@GetMapping("/getDummyCar")
	public @ResponseBody Car getDummyCar() {
		Car car = new Car ("ABC123", "Audi", 2009, "Jonas", 860051211, "Headlights do not work");
		car.addTask(new Task ("diagnostics", "Done", ""));
		car.addTask(new Task ("changing bulb", "In Progress", ""));
		return car;
	}
	
	@PostMapping("/saveTask")
	public String saveTask (Task task) {
		taskService.save(task);
		return "redirect:/index";
	}
	
	@PostMapping("/saveTaskJson")
	public String saveTaskJson (@RequestBody Task task) {
		taskService.save(task);
		return "redirect:/index";
	}
	
	@GetMapping("/getDummy")
	public @ResponseBody Task getDummy() {
		return new Task ("taskname", "taskstatus", "taskcomment");
	}
	
	@GetMapping("/add")
    public String showCreateForm(Car car) {
        return "serviceAdvisor/add-car";
	}
	
	

}
