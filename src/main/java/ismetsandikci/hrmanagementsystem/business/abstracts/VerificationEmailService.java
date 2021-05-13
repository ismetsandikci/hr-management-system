package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationEmail;


public interface VerificationEmailService {

	List<VerificationEmail> getAll();
}
