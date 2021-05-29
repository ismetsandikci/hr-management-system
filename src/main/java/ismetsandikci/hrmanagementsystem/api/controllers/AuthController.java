package ismetsandikci.hrmanagementsystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.AuthService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Candidate;
import ismetsandikci.hrmanagementsystem.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerforemployer")
    public Result registerForEmployer(@RequestBody Employer employer, String passwordRepeat) {
        return authService.registerForEmployer(employer, passwordRepeat);
    }

    @PostMapping("/registerforcandidate")
    public Result registerForCandidate(@RequestBody Candidate candidate, String passwordRepeat) {
        return authService.registerForCandidate(candidate, passwordRepeat);
    }
	
}
