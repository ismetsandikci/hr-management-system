package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeCoverLetterService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeCoverLetterDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeCoverLetter;

@Service("ResumeCoverLetterManager")
public class ResumeCoverLetterManager implements ResumeCoverLetterService {

	private ResumeCoverLetterDao resumeCoverLetterDao;
	
	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao) {
		super();
		this.resumeCoverLetterDao = resumeCoverLetterDao;
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAll() {
		return new SuccessDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.findAll());
	}

	@Override
	public DataResult<ResumeCoverLetter> getById(int id) {
		Optional<ResumeCoverLetter> resumeCoverLetter = this.resumeCoverLetterDao.findById(id);

		if (resumeCoverLetter.isEmpty()){
			return new ErrorDataResult<ResumeCoverLetter>("CV Ön Yazı bulunamadı");
		}
		return new SuccessDataResult<ResumeCoverLetter>(resumeCoverLetter.get());
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Eklendi.");
	}

	@Override
	public Result update(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Güncellendi.");
	}

	@Override
	public Result delete(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.delete(resumeCoverLetter);
		return new SuccessResult("CV Ön Yazı Silindi.");
	}

}
