package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationEmail;

public interface VerificationEmailDao extends JpaRepository<VerificationEmail, Integer>{

}
