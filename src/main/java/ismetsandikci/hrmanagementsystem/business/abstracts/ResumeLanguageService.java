package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService {

	DataResult<List<ResumeLanguage>> getAll();
	
	DataResult<ResumeLanguage> getById(int id);
	
	DataResult<List<ResumeLanguage>> getAllByResume_Id(int resumeId);
	
	Result add(ResumeLanguage resumeLanguage);
	
	Result update(ResumeLanguage resumeLanguage);
	
	Result delete(ResumeLanguage resumeLanguage);
}
