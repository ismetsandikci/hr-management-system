package ismetsandikci.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {

	@Id
	@Column(name="userid")
	private int userId;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	public Employee() {
		
	}
	
	public Employee(int userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
