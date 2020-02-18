package by.eslaikouskaya.repository;

import by.eslaikouskaya.pojo.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
	City findByName(String name);
}
