package ismetsandikci.hrmanagementsystem.business.abstracts;

import java.util.List;

import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
	
	DataResult<City> getById(int id);
	
	Result add (City city);
	
	Result update (City city);
	
	Result delete (City city);
}
