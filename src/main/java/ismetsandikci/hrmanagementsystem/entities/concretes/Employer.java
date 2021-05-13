package ismetsandikci.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employers")
@Data
public class Employer {
	
	@Id
	@Column(name="userid")
	private int userId;

	@Column(name="companyname")
	private String companyName;

	@Column(name="webaddress")
	private String webAddress;

	@Column(name="phonenumber")
	private String phoneNumber;

	public Employer() {
		
	}
	
	public Employer(int userId, String companyName, String webAddress, String phoneNumber) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
	}

}
