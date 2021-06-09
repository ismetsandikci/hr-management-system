package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLink;

public interface ResumeLinkService {

	DataResult<List<ResumeLink>> getAll();
	
	DataResult<ResumeLink> getById(int id);
	
	DataResult<List<ResumeLink>> getAllByResume_Id(int resumeId);
	
	Result add(ResumeLink resumeLink);
	
	Result update(ResumeLink resumeLink);
	
	Result delete(ResumeLink resumeLink);
}
