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

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeLinkService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.ResumeLink;

@RestController
@RequestMapping("/api/resumeLinks")
@CrossOrigin
public class ResumeLinksController {

	private ResumeLinkService resumeLinkService;

	@Autowired
	public ResumeLinksController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<ResumeLink>>> getAll() {
		return ResponseEntity.ok(this.resumeLinkService.getAll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<DataResult<ResumeLink>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeLinkService.getById(id));
	}
	
	@GetMapping("/getAllByResume_Id")
	public ResponseEntity<DataResult<List<ResumeLink>>> getAllByResume_Id(@RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeLinkService.getAllByResume_Id(resumeId));
	}
	
	@PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody ResumeLink resumeLink){
        return ResponseEntity.ok(this.resumeLinkService.add(resumeLink));
    }
	
	@PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody ResumeLink resumeLink){
        return ResponseEntity.ok(this.resumeLinkService.update(resumeLink));
    }
	
	@PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody ResumeLink resumeLink){
        return ResponseEntity.ok(this.resumeLinkService.delete(resumeLink));
    }
}
