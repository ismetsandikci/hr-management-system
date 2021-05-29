package ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mernis;

import java.time.LocalDate;

public interface UserValidationService {
	
	boolean CheckIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate birthDate);
	
}
