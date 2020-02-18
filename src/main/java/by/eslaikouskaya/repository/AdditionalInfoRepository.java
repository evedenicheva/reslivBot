package by.eslaikouskaya.repository;

import by.eslaikouskaya.pojo.AdditionalInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdditionalInfoRepository extends CrudRepository<AdditionalInfo, Long> {
	List<AdditionalInfo> findByCityId(Long cityId);
}
