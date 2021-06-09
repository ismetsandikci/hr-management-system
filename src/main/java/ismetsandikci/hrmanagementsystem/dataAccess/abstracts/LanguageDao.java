package ismetsandikci.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ismetsandikci.hrmanagementsystem.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	
	Language getById(int id);
}
