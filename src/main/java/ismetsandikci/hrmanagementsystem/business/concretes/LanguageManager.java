package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.LanguagesService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.LanguageDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.Language;

@Service("LanguageManager")
public class LanguageManager implements LanguagesService {

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Diller Listelendi");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.getById(id), "Dil Listelendi");
	}

	@Override
	public Result add(Language language) {
		language.setActive(true);
		
		this.languageDao.save(language);

		return new SuccessResult("Dil Eklendi");
	}

	@Override
	public Result update(Language language) {
		languageDao.save(language);
		return new SuccessResult("Dil Güncellendi");
	}

	@Override
	public Result delete(Language language) {
		languageDao.delete(language);
		return new SuccessResult("Dil Silindi");
	}

}
