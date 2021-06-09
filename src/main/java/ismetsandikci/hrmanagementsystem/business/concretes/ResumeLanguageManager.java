package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeLanguageService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeLanguageDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLanguage;


@Service("ResumeLanguageManager")
public class ResumeLanguageManager implements ResumeLanguageService {

	private ResumeLanguageDao resumeLanguageDao;

	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAll() {
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.findAll());
	}

	@Override
	public DataResult<ResumeLanguage> getById(int id) {
		Optional<ResumeLanguage> resumeLanguage = this.resumeLanguageDao.findById(id);

		if (resumeLanguage.isEmpty()){
			return new ErrorDataResult<ResumeLanguage>("CV Dil Bilgisi bulunamadı");
		}
		return new SuccessDataResult<ResumeLanguage>(resumeLanguage.get());
	}

	@Override
	public DataResult<List<ResumeLanguage>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeLanguage>>(this.resumeLanguageDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		System.out.println("resumeLanguage add ->" + resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Eklendi.");
	}

	@Override
	public Result update(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.save(resumeLanguage);
		System.out.println("resumeLanguage update ->" + resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Güncellendi.");
	}

	@Override
	public Result delete(ResumeLanguage resumeLanguage) {
		this.resumeLanguageDao.delete(resumeLanguage);
		return new SuccessResult("CV Dil Bilgisi Silindi.");
	}
}
