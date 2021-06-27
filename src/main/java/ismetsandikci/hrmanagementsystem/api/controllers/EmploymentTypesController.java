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

import ismetsandikci.hrmanagementsystem.business.abstracts.EmploymentTypeService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.EmploymentType;

@RestController
@RequestMapping("/api/employmenttypes")
@CrossOrigin
public class EmploymentTypesController {
	private EmploymentTypeService employmentTypeService;

    @Autowired
    public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<EmploymentType>>> getAll(){
        return ResponseEntity.ok(this.employmentTypeService.getAll());
    }
    

    @GetMapping("/getbyid")
    public ResponseEntity<DataResult<EmploymentType>> getById(@RequestParam int id){
        return ResponseEntity.ok(this.employmentTypeService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody EmploymentType employmentType){
        return ResponseEntity.ok(this.employmentTypeService.add(employmentType));
    }

}
