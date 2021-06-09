package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeEducationService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeEducationDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeEducation;

@Service("ResumeEducationManager")
public class ResumeEducationManager implements ResumeEducationService {
	
	private ResumeEducationDao resumeEducationDao;

	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao) {
		super();
		this.resumeEducationDao = resumeEducationDao;
	}

	@Override
	public DataResult<List<ResumeEducation>> getAll() {
		return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.findAll());
	}

	@Override
	public DataResult<ResumeEducation> getById(int id) {
		Optional<ResumeEducation> resumeEducation = this.resumeEducationDao.findById(id);

		if (resumeEducation.isEmpty()){
			return new ErrorDataResult<ResumeEducation>("CV Eğitim bulunamadı");
		}
		return new SuccessDataResult<ResumeEducation>(resumeEducation.get());
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDate(int resumeId) {
		return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_IdOrderByGraduationDate(resumeId));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAllByResume_IdOrderByGraduationDateDesc(int resumeId) {
		return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.getAllByResume_IdOrderByGraduationDateDesc(resumeId));
	}

	@Override
	public Result add(ResumeEducation resumeEducation) {
		this.resumeEducationDao.save(resumeEducation);
		return new SuccessResult("CV Eğitim Eklendi.");
	}

	@Override
	public Result update(ResumeEducation resumeEducation) {
		this.resumeEducationDao.save(resumeEducation);
		return new SuccessResult("CV Eğitim Güncellendi.");
	}

	@Override
	public Result delete(ResumeEducation resumeEducation) {
		this.resumeEducationDao.delete(resumeEducation);
		return new SuccessResult("CV Eğitim Silindi.");
	}

}
