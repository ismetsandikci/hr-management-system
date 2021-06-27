package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Resume;

public interface ResumeService {
	
	DataResult<List<Resume>> getAll();
	
    DataResult<Resume> getById(int id);
    
    DataResult<List<Resume>> getByCandidateId(int candidateId);
    
    Result uploadPhoto(int candidateId, MultipartFile file);

    Result add(Resume resume);
    
    Result update(Resume resume);
    
    Result delete(Resume resume);
}
