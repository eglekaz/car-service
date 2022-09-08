package lt.codeacademy.learn.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Size(min= 2, max = 10)
	String numberPlate;
	
	@NotBlank 
	String manufacturer;
	
	@NotNull
	int yearOfManufact;
	
	@NotBlank  
	String ownerName;
	
	@Digits(fraction = 0, integer = 9)
	long phoneNum;
	
	@NotBlank  
	String primaryComplaint;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Task> tasks = new ArrayList<Task>();
	
	@NotBlank
	String status;
	
	@PositiveOrZero
	double cost;
	
	public Car() { }
	
	public Car(String numberPlate, String manufacturer, int yearOfManufact, String ownerName, long phoneNum,
			String primaryComplaint) {
		this.numberPlate = numberPlate;
		this.manufacturer = manufacturer;
		this.yearOfManufact = yearOfManufact;
		this.ownerName = ownerName;
		this.phoneNum = phoneNum;
		this.primaryComplaint = primaryComplaint;
	}
	
	public Car(String numberPlate, String manufacturer, int yearOfManufact, String ownerName, long phoneNum,
			String primaryComplaint, String status, double cost) {
		this.numberPlate = numberPlate;
		this.manufacturer = manufacturer;
		this.yearOfManufact = yearOfManufact;
		this.ownerName = ownerName;
		this.phoneNum = phoneNum;
		this.primaryComplaint = primaryComplaint;
		this.status=status;
		this.cost=cost;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYearOfManufact() {
		return yearOfManufact;
	}

	public void setYearOfManufact(int yearOfManufact) {
		this.yearOfManufact = yearOfManufact;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPrimaryComplaint() {
		return primaryComplaint;
	}

	public void setPrimaryComplaint(String primaryComplaint) {
		this.primaryComplaint = primaryComplaint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask (Task task) {
		this.tasks.add(task);
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", numberPlate=" + numberPlate + ", manufacturer=" + manufacturer + ", yearOfManufact="
				+ yearOfManufact + ", ownerName=" + ownerName + ", phoneNum=" + phoneNum + ", primaryComplaint="
				+ primaryComplaint + ", tasks=" + tasks + ", status=" + status + ", cost=" + cost + "]";
	}

	
}
