package ismetsandikci.hrmanagementsystem.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="isactive")
	private boolean isActive;

	@Column(name="createddate")
	private Date createdDate;

	public User() {
		
	}
	
	public User(int id, String email, String password, boolean isActive, Date createdDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}
}
