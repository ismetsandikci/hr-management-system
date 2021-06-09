package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLink;

public interface ResumeLinkDao extends JpaRepository<ResumeLink, Integer> {

	List<ResumeLink> getAllByResume_Id(int resumeId);
}
