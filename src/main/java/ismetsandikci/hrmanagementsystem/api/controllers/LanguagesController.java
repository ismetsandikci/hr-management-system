package ismetsandikci.hrmanagementsystem.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ismetsandikci.hrmanagementsystem.business.abstracts.LanguagesService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguagesService languagesService;
	
	@Autowired
	public LanguagesController(LanguagesService languagesService) {
		super();
		this.languagesService = languagesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll() {
		return this.languagesService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Language> getById(@RequestParam int id) {
		return this.languagesService.getById(id);
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody Language language){
        return this.languagesService.add(language);
    }
	
	@PostMapping("/update")
    public Result update(@RequestBody Language language){
        return this.languagesService.update(language);
    }
	
	@PostMapping("/delete")
    public Result delete(@RequestBody Language language){
        return this.languagesService.delete(language);
    }
}
