package ismetsandikci.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employer_phones")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerPhone {
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="employer_id")
	private int employerId;

	@Column(name="phone_number")
	private String phoneNumber;
}
