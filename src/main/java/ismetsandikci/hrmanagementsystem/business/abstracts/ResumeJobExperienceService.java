package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeJobExperience;

public interface ResumeJobExperienceService {
	
	DataResult<List<ResumeJobExperience>> getAll();
	
	DataResult<ResumeJobExperience> getById(int id);
	
	DataResult<List<ResumeJobExperience>> getAllByResume_Id(int resumeId);
	
	DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDate(int resumeId);
	
	DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDateDesc(int resumeId);
	
	Result add(ResumeJobExperience resumeJobExperience);
	
	Result update(ResumeJobExperience resumeJobExperience);
	
	Result delete(ResumeJobExperience resumeJobExperience);
}
