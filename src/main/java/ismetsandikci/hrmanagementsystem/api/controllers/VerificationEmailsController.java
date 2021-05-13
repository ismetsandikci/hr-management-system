package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.VerificationEmailService;
import ismetsandikci.hrmanagementsystem.entities.concretes.VerificationEmail;

@RestController
@RequestMapping("/api/verificationemails")
public class VerificationEmailsController {

	private VerificationEmailService verificationEmailService;

	public VerificationEmailsController(VerificationEmailService verificationEmailService) {
		super();
		this.verificationEmailService = verificationEmailService;
	}
	
	@GetMapping("/getall")
	public List<VerificationEmail> getAll() {
		return this.verificationEmailService.getAll();
	}
}
