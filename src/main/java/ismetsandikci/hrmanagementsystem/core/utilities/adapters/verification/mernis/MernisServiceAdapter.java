package ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserValidationService {

	@Override
	public boolean CheckIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate birthDate) {
		// TODO Auto-generated method stub
		return true;
	}
}
