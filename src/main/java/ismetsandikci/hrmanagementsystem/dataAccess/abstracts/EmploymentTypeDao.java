package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.EmploymentType;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {

	EmploymentType getById(int id);
}
