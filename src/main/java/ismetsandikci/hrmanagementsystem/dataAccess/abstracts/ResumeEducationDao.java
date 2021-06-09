package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeEducation;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer> {
	
	List<ResumeEducation> getAllByResume_Id(int resumeId);
	
	List<ResumeEducation> getAllByResume_IdOrderByGraduationDate(int resumeId);

	List<ResumeEducation> getAllByResume_IdOrderByGraduationDateDesc(int resumeId);
}
