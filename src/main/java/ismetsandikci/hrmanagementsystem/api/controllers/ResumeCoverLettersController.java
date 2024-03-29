package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeCoverLetterService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeCoverLetter;

@RestController
@RequestMapping("/api/resumeCoverLetters")
@CrossOrigin
public class ResumeCoverLettersController {

	private ResumeCoverLetterService resumeCoverLetterService;
	
	@Autowired
	public ResumeCoverLettersController(ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeCoverLetterService = resumeCoverLetterService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeCoverLetter>>> getAll() {
		return ResponseEntity.ok(this.resumeCoverLetterService.getAll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeCoverLetter>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeCoverLetterService.getById(id));
	}
	
	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeCoverLetter>>> getAllByResume_Id(@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeCoverLetterService.getAllByResume_Id(resumeId));
	}
	
	@PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody ResumeCoverLetter resumeCoverLetter){
        return ResponseEntity.ok(this.resumeCoverLetterService.add(resumeCoverLetter));
    }
	
	@PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody ResumeCoverLetter resumeCoverLetter){
        return ResponseEntity.ok(this.resumeCoverLetterService.update(resumeCoverLetter));
    }
	
	@PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody ResumeCoverLetter resumeCoverLetter){
        return ResponseEntity.ok(this.resumeCoverLetterService.delete(resumeCoverLetter));
    }
}
