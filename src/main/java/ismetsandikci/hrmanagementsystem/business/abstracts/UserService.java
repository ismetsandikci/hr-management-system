package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.entities.concretes.User;


public interface UserService {
	List<User> getAll();
}
