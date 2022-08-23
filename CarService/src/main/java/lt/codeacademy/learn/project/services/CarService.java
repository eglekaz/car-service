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
	
	public Car findById (int id) {
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid car Id: " + id));
		return car;
	}
	
	public void delete (Car car) {
		carRepository.delete(car);
	}
	
	
	
}
