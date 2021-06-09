package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeEducation;

public interface ResumeEducationService {
	
	DataResult<List<ResumeEducation>> getAll();
	
	DataResult<ResumeEducation> getById(int id);
	
	DataResult<List<ResumeEducation>> getAllByResume_Id(int resumeId);
	
	DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDate(int resumeId);
	
	DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDateDesc(int resumeId);
	
	Result add(ResumeEducation resumeEducation);
	
	Result update(ResumeEducation resumeEducation);
	
	Result delete(ResumeEducation resumeEducation);
}
