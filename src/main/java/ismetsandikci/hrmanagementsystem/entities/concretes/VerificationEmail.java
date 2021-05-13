package ismetsandikci.hrmanagementsystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="verificationemails")
@Data
public class VerificationEmail {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="userid")
	private int userId;

	@Column(name="verificationcode")
	private String verificationCode;

	@Column(name="verificationdate")
	private Date verificationDate;

	public VerificationEmail() {
		
	}
	
	public VerificationEmail(int id, int userId, String verificationCode, Date verificationDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.verificationCode = verificationCode;
		this.verificationDate = verificationDate;
	} 

}
