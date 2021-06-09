package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeLinkService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeLinkDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLink;

@Service("ResumeLinkManager")
public class ResumeLinkManager implements ResumeLinkService{

	private ResumeLinkDao resumeLinkDao;

	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll());
	}

	@Override
	public DataResult<ResumeLink> getById(int id) {
		Optional<ResumeLink> resumeLink = this.resumeLinkDao.findById(id);

		if (resumeLink.isEmpty()){
			return new ErrorDataResult<ResumeLink>("CV Link bulunamadı");
		}
		return new SuccessDataResult<ResumeLink>(resumeLink.get());
	}

	@Override
	public DataResult<List<ResumeLink>> getAllByResume_Id(int resumeId) {
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.getAllByResume_Id(resumeId));
	}

	@Override
	public Result add(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		System.out.println("resumeLink add ->" + resumeLink);
		return new SuccessResult("CV Link Eklendi.");
	}

	@Override
	public Result update(ResumeLink resumeLink) {
		this.resumeLinkDao.save(resumeLink);
		System.out.println("resumeLink update ->" + resumeLink);
		return new SuccessResult("CV Link Güncellendi.");
	}

	@Override
	public Result delete(ResumeLink resumeLink) {
		this.resumeLinkDao.delete(resumeLink);
		return new SuccessResult("CV Link Silindi.");
	}
}
