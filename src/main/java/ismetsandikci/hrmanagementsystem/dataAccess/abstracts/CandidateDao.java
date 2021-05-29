package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	Candidate findByNationalityId(String nationalityId);
	
	Candidate findByEmail(String emailAddress);
}
