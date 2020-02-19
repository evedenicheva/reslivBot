package by.eslaikouskaya.service;

import by.eslaikouskaya.cmd.AdditionalInfoCmd;
import by.eslaikouskaya.cmd.CityCmd;
import by.eslaikouskaya.dto.AdditionalInfoDto;
import by.eslaikouskaya.dto.CityDto;
import by.eslaikouskaya.pojo.AdditionalInfo;
import by.eslaikouskaya.pojo.City;
import by.eslaikouskaya.repository.AdditionalInfoRepository;
import by.eslaikouskaya.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	AdditionalInfoRepository infoRepository;

	public List<CityDto> getAllCities(int maxCount) {
		List<CityDto> cityDtos = new ArrayList<>();
		cityRepository.findAll().forEach(
				city -> {
					CityDto dto = new CityDto(city.getId(),
							city.getName());
					if (cityDtos.size() < maxCount){ cityDtos.add(dto); }
				});
		return cityDtos;
	}

	public CityDto getCityById(int cityId) {
		City city = cityRepository.findById((long)cityId).orElseThrow();
		return new CityDto(city.getId(), city.getName());
	}

	public void createNewCity(CityCmd cityCmd) {
		City city = new City();
		city.setName(cityCmd.getName());
		cityRepository.save(city);
	}

	public void updateCity(CityCmd cityCmd) {
		City city = new City();
		city.setId(cityCmd.getId());
		city.setName(cityCmd.getName());
		cityRepository.save(city);
	}

	public void deleteCity(int id){
		cityRepository.deleteById((long) id);
	}

	public List<AdditionalInfoDto> getAllInfos(int maxCount) {
		List<AdditionalInfoDto> infoDtos = new ArrayList<>();
		infoRepository.findAll().forEach(
				info -> {
					AdditionalInfoDto dto = new AdditionalInfoDto(info.getId(),
							info.getCityId(), info.getInfo());
					if (infoDtos.size() < maxCount){ infoDtos.add(dto); }
				});
		return infoDtos;
	}

	public AdditionalInfoDto getInfoById(int infoId) {
		AdditionalInfo info = infoRepository.findById((long)infoId).orElseThrow();
		return new AdditionalInfoDto(info.getId(),
				info.getCityId(), info.getInfo());
	}

	public void createNewInfo(AdditionalInfoCmd newInfoCmd) {
		AdditionalInfo info = new AdditionalInfo();
		info.setCityId(newInfoCmd.getCityId());
		info.setInfo(newInfoCmd.getInfo());
		infoRepository.save(info);
	}

	public void updateInfo(AdditionalInfoCmd infoCmd) {
		AdditionalInfo additionalInfo = new AdditionalInfo();
		additionalInfo.setId(infoCmd.getId());
		additionalInfo.setInfo(infoCmd.getInfo());
		additionalInfo.setCityId(infoCmd.getCityId());
		infoRepository.save(additionalInfo);
	}

	public void deleteInfo(int id) {
		infoRepository.deleteById((long) id);
	}

	public City findCityByCityName(String name) {
		return cityRepository.findByName(name);
	}

	public List<AdditionalInfo> findInfoByCityId(Long id) {
		return infoRepository.findByCityId(id);
	}
}
