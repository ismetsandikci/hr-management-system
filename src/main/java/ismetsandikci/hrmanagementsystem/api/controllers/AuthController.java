package ismetsandikci.hrmanagementsystem.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.AuthService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.dtos.CandidateForRegisterDto;
import ismetsandikci.hrmanagementsystem.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerforcandidate")
    public Result registerForCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
        return authService.registerForCandidate(candidateForRegisterDto);
    }
	
	@PostMapping("/registerforemployer")
    public Result registerForEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
        return authService.registerForEmployer(employerForRegisterDto);
    }

}
