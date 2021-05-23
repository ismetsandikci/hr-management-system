package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
}
