package lt.codeacademy.learn.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.learn.project.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
	
	Car findByNumberPlateAndPhoneNum(String numberPlate, long phoneNum);

}
