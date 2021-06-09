package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeSkill;

public interface ResumeSkillDao extends JpaRepository<ResumeSkill, Integer> {
	
	List<ResumeSkill> getAllByResume_Id(int resumeId);
}
