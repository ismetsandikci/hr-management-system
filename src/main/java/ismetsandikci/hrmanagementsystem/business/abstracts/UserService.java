package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
}
