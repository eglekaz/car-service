package lt.codeacademy.learn.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lt.codeacademy.learn.project.entities.Car;
import lt.codeacademy.learn.project.repositories.CarRepository;

@DataJpaTest
class CarRepositoryTest {

	@Autowired
	private CarRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	@Test
	void testSave() {
		// given
		Car car = new Car (
				"ABC020", 
				"Audi", 
				2009, 
				"Jonas", 
				860051211, 
				"Headlights do not work",
				"NOT_STARTED",
				0
		);
		
		// when
		underTest.save(car);
		
		// then
		assertThat(underTest.count()>0);
		
	}

	@Test
	void itShouldFindCarById() {
		// given
		int carId = 2;
		Car car = new Car (
				"ABC123", 
				"Audi", 
				2009, 
				"Jonas", 
				860051211, 
				"Headlights do not work",
				"NOT_STARTED",
				0
		);
		underTest.save(car);
		
		// when
		Car expectedCar = underTest.findById(carId).get();
		
		// then
		assertThat(expectedCar.equals(car));
	}

	@Test
	void testFindByNumberPlateAndPhoneNum() {
		// given
		String numPlate = "ABC123";
		long phoneNum = 860051211;
		
		Car car = new Car (
				"ABC123", 
				"Audi", 
				2009, 
				"Jonas", 
				860051211, 
				"Headlights do not work",
				"NOT_STARTED",
				0
		);
		underTest.save(car);
		
		// when
		Car expectedCar = underTest.findByNumberPlateAndPhoneNum(numPlate, phoneNum);
		// then
		assertThat(expectedCar.equals(car));
	}
	
	@Test
	void testDeleteById() {
		// given
		int carId = 4;
		Car car = new Car (
				"ABC123", 
				"Audi", 
				2009, 
				"Jonas", 
				860051211, 
				"Headlights do not work",
				"NOT_STARTED",
				0
		);
		underTest.save(car);
		
		// when
		underTest.deleteById(carId);
		
		// then
		assertThat(underTest.count()==0);
	}

}
