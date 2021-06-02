package ismetsandikci.hrmanagementsystem.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import ismetsandikci.hrmanagementsystem.business.abstracts.CityService;
import ismetsandikci.hrmanagementsystem.core.utilities.results.DataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.Result;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessDataResult;
import ismetsandikci.hrmanagementsystem.core.utilities.results.SuccessResult;
import ismetsandikci.hrmanagementsystem.dataAccess.abstracts.CityDao;
import ismetsandikci.hrmanagementsystem.entities.concretes.City;

@Service("CityManager")
public class CityManager implements CityService {

	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehiler Listelendi");
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.getById(id));
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("City added.");
	}

	@Override
	public Result update(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(City city) {
		// TODO Auto-generated method stub
		return null;
	}

}
