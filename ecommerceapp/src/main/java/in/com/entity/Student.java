package in.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "studentdetails")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rollno")
	private int rollNumber;
	
	@Column(name="sname", length = 75)
	private String name;
	
	@Column(name="coursename", length = 100)
	private String course;
	
	@Column(name="branch" , nullable = true)
	private String branch;
	
	@Column(name="passingyear" , nullable = true)
	private int yearofPassing;
	
	
}
