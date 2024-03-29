package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	
	Optional<List<Resume>> getByCandidateId(int candidateId);
}
