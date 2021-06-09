package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Language;

public interface LanguagesService {

	DataResult<List<Language>> getAll();
	
	DataResult<Language> getById(int id);
	
	Result add(Language language);
	
	Result update(Language language);
	
	Result delete(Language language);
}
