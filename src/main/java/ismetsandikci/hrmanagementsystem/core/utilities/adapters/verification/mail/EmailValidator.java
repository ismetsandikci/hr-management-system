package ismetsandikci.hrmanagementsystem.core.utilities.adapters.verification.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	public static boolean isEmailValid(String emailAddress) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailAddress);
		
		if(matcher.matches() == false) {
			System.out.println("E-mail bilgisi istenilen kosullari saglamiyor : " + emailAddress);
			return false;
		}
		return true;
	}
}
