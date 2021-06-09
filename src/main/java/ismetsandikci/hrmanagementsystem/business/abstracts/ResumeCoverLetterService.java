package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeCoverLetter;

public interface ResumeCoverLetterService {

	DataResult<List<ResumeCoverLetter>> getAll();
	
	DataResult<ResumeCoverLetter> getById(int id);
	
	DataResult<List<ResumeCoverLetter>> getAllByResume_Id(int resumeId);
	
	Result add(ResumeCoverLetter resumeCoverLetter);
	
	Result update(ResumeCoverLetter resumeCoverLetter);
	
	Result delete(ResumeCoverLetter resumeCoverLetter);
}
