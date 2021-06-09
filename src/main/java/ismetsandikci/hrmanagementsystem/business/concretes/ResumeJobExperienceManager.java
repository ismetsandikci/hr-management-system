package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeJobExperienceService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeJobExperienceDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeJobExperience;

@Service("ResumeJobExperienceManager")
public class ResumeJobExperienceManager implements ResumeJobExperienceService{

	private ResumeJobExperienceDao resumeJobExperienceDao;

	@Autowired
	public ResumeJobExperienceManager(ResumeJobExperienceDao resumeJobExperienceDao) {
		super();
		this.resumeJobExperienceDao = resumeJobExperienceDao;
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAll() {
		return new SuccessDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.findAll());
	}

	@Override
	public DataResult<ResumeJobExperience> getById(int id) {
		Optional<ResumeJobExperience> resumeJobExperience = this.resumeJobExperienceDao.findById(id);

		if (resumeJobExperience.isEmpty()){
			return new ErrorDataResult<ResumeJobExperience>("CV İş Deneyimi bulunamadı");
		}
		return new SuccessDataResult<ResumeJobExperience>(resumeJobExperience.get());
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.getAllByResume_Id(resumeId));
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDate(int resumeId) {
		return new SuccessDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.getAllByResume_IdOrderByFinishDate(resumeId));
	}

	@Override
	public DataResult<List<ResumeJobExperience>> getAllByResume_IdOrderByFinishDateDesc(int resumeId) {
		return new SuccessDataResult<List<ResumeJobExperience>>(this.resumeJobExperienceDao.getAllByResume_IdOrderByFinishDateDesc(resumeId));
	}

	@Override
	public Result add(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.save(resumeJobExperience);
		return new SuccessResult("CV İş Deneyimi Eklendi.");
	}

	@Override
	public Result update(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.save(resumeJobExperience);
		return new SuccessResult("CV İş Deneyimi Güncellendi.");
	}

	@Override
	public Result delete(ResumeJobExperience resumeJobExperience) {
		this.resumeJobExperienceDao.save(resumeJobExperience);
		return new SuccessResult("CV İş Deneyimi Silindi.");
	}
}
