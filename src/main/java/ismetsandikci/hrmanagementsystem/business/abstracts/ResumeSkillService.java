package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeSkill;

public interface ResumeSkillService {

	DataResult<List<ResumeSkill>> getAll();
	
	DataResult<ResumeSkill> getById(int id);
	
	DataResult<List<ResumeSkill>> getAllByResume_Id(int resumeId);
	
	Result add(ResumeSkill resumeSkill);
	
	Result update(ResumeSkill resumeSkill);
	
	Result delete(ResumeSkill resumeSkill);
}
