package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeService;
import ismetsandikci.hrmanagementsystem.core.utilities.image.ImageService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.ErrorDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.ResumeDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.Resume;

@Service("ResumeManager")
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;

	private ImageService imageService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, ImageService imageService) {
		super();
		this.resumeDao = resumeDao;

		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getById(int id) {
		Optional<Resume> resume = this.resumeDao.findById(id);

		if (resume.isEmpty()){
			return new ErrorDataResult<Resume>("CV bulunamadı");
		}
		return new SuccessDataResult<Resume>(resume.get());
	}

	@Override
	public DataResult<List<Resume>> getByCandidateId(int candidateId) {
		Optional<List<Resume>> candidateResult = this.resumeDao.getByCandidateId(candidateId);
		
		if (candidateResult.isEmpty()) {
			return new ErrorDataResult<List<Resume>>("İş Arayanın Cv Bulunamadı");
		}
		return new SuccessDataResult<List<Resume>>(candidateResult.get(), "İş Arayanın Cv Listelendi");
	}

	@Override
	public Result uploadPhoto(int candidateId, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) this.imageService.uploadPhoto(file).getData();
		String url = result.get("url");
		List<Resume> resumesAddPhoto = this.getByCandidateId(candidateId).getData();
		for (Resume resume : resumesAddPhoto) {
			resume.setImage(url);
			this.resumeDao.save(resume);
		}
		
		return new SuccessResult();
	}
	
	@Override
	public Result add(Resume resume) {
		//this.resumeDao.save(resume);
		System.out.println(resume);
		System.out.println(resume.getResumeEducations());
		return new SuccessResult("CV Eklendi.");
	}

	@Override
	public Result update(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("CV Güncellendi.");
	}

	@Override
	public Result delete(Resume resume) {
		this.resumeDao.delete(resume);
		return new SuccessResult("CV Silindi.");
	}

}
