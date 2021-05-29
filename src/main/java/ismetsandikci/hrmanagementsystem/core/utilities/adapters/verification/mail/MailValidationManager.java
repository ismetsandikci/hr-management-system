package ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mail;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class MailValidationManager implements ValidationService {

	@Override
	public boolean sendVerificationCode(String emailAddress, String code) {
		System.out.println(emailAddress + " mail adresine kod gönderildi. Doğrulama Kodu: " + code);
		return true;
	}

	@Override
	public String codeGenerator() {
		int length = 10;
		
		// ASCII range – alphanumeric (0-9, a-z, A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		// each iteration of the loop randomly chooses a character from the given
		// ASCII range and appends it to the `StringBuilder` instance

		for (int i = 0; i < length; i++)
		{
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

}
