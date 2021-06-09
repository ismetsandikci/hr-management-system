package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterDao extends JpaRepository<ResumeCoverLetter, Integer> {
	
	List<ResumeCoverLetter> getAllByResume_Id(int resumeId);
}
