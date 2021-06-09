package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeSkillService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeSkillDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeSkill;

@Service("ResumeSkillManager")
public class ResumeSkillManager implements ResumeSkillService {

	private ResumeSkillDao resumeSkillDao;

	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
	}

	@Override
	public DataResult<List<ResumeSkill>> getAll() {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.findAll());
	}

	@Override
	public DataResult<ResumeSkill> getById(int id) {
		Optional<ResumeSkill> resumeSkill = this.resumeSkillDao.findById(id);

		if (resumeSkill.isEmpty()){
			return new ErrorDataResult<ResumeSkill>("CV Beceri bulunamadı");
		}
		return new SuccessDataResult<ResumeSkill>(resumeSkill.get());
	}

	@Override
	public DataResult<List<ResumeSkill>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeSkill>>(this.resumeSkillDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("CV Beceri Eklendi.");
	}

	@Override
	public Result update(ResumeSkill resumeSkill) {
		this.resumeSkillDao.save(resumeSkill);
		return new SuccessResult("CV Beceri Güncellendi.");
	}

	@Override
	public Result delete(ResumeSkill resumeSkill) {
		this.resumeSkillDao.delete(resumeSkill);
		return new SuccessResult("CV Beceri Silindi.");
	}
}
