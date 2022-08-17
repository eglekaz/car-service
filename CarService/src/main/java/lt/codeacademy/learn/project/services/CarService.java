package lt.codeacademy.learn.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.learn.project.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;
}
