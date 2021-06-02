package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

	City getById(int id);
}
