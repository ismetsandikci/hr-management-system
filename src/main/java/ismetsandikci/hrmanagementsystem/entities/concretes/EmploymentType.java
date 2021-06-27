package ismetsandikci.hrmanagementsystem.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employment_types")
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name="is_active")
	@JsonIgnore
	private Boolean isActive = true;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="employmentType")
	private List<JobPosting> JobPostings;
}
