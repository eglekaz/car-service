package lt.codeacademy.learn.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.models.SubmitInfo;
import lt.codeacademy.learn.project.services.CarService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CarService carService;
	
	@GetMapping("/find")
    public String showSearchForm(Model model) {
		model.addAttribute("submitInfo", new SubmitInfo());
        return "customer/find-car";
	}
	
	@PostMapping("/yourCar")
	public String showCustomerCar (SubmitInfo info, Model model) {
		Car car = carService.findByNumberPlateAndPhoneNum(info.getPlate(), info.getPhone());
		if (car==null) {
			return "error-405";
		}
		model.addAttribute("car", car);
		return "customer/car";
	}
	
}
