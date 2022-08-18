package lt.codeacademy.learn.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;
	
	public Car save (Car car) {
		return carRepository.save(car);
	}
	
	public List<Car> getAll() {
		return carRepository.findAll();
	}
	
}
