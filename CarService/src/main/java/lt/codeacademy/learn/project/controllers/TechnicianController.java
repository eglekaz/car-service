package lt.codeacademy.learn.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.learn.project.entities.Car;
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
	
}