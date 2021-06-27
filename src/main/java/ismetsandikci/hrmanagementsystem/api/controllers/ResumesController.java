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
import org.springframework.web.multipart.MultipartFile;

import ismetsandikci.hrmanagementsystem.business.abstracts.ResumeService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<Resume>>> getAll() {
		return ResponseEntity.ok(this.resumeService.getAll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<DataResult<Resume>> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.resumeService.getById(id));
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<DataResult<List<Resume>>> getByCandidateId(@RequestParam int candidateId) {
		return ResponseEntity.ok(this.resumeService.getByCandidateId(candidateId));
	}
	
	@PostMapping("/uploadPhoto")
	public Result uploadImage(@RequestParam int candidateId,@RequestBody MultipartFile file)
	{
		return this.resumeService.uploadPhoto(candidateId,file);
	}
	
	@PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Resume resume){
        return ResponseEntity.ok(this.resumeService.add(resume));
    }
	
	@PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Resume resume){
        return ResponseEntity.ok(this.resumeService.update(resume));
    }
	
	@PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody Resume resume){
        return ResponseEntity.ok(this.resumeService.delete(resume));
    }
}
