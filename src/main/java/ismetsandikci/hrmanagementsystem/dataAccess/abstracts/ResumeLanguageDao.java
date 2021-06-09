package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLanguage;

public interface ResumeLanguageDao extends JpaRepository<ResumeLanguage, Integer> {

	List<ResumeLanguage> getAllByResume_Id(int resumeId);
}
