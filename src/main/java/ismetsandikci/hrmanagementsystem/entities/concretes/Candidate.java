package ismetsandikci.hrmanagementsystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="candidates")
@Data
public class Candidate {

	@Id
	@Column(name="userid")
	private int userId;

	@Column(name="firstname")
	private String firstName;

	@Column(name="lastname")
	private String lastName;

	@Column(name="nationalityid")
	private String nationalityId;

	@Column(name="dateofbirth")
	private Date dateofbirth;
	
	public Candidate() {
		
	}
	
	public Candidate(int userId, String firstName, String lastName, String nationalityId, Date dateofbirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateofbirth = dateofbirth;
	}
	
	
	
}
