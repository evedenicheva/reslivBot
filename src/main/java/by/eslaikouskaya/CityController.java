package by.eslaikouskaya;

import by.eslaikouskaya.cmd.CityCmd;
import by.eslaikouskaya.dto.CityDto;
import by.eslaikouskaya.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

	@Autowired
	CityService service;

	@GetMapping("/city")
	public List<CityDto> getCities(@RequestParam int maxCount) {
		if (maxCount < 1) throw new IllegalArgumentException();
		return service.getAllCities(maxCount);
	}

	@GetMapping("/city/{cityId}")
	public CityDto getCity(@PathVariable("cityId") int cityId) {
		return service.getCityById(cityId);
	}

	@PostMapping("/city")
	public void createNewCity(@RequestBody CityCmd newCityCmd) {
		service.createNewCity(newCityCmd);
	}

	@PutMapping("/city")
	public void updateCity(@RequestBody CityCmd cityCmd) {
		service.updateCity(cityCmd);
	}

	@DeleteMapping("/city/{id}")
	public void deleteCity(@PathVariable int id) {
		service.deleteCity(id);
	}

}
