package by.eslaikouskaya;

import by.eslaikouskaya.cmd.AdditionalInfoCmd;
import by.eslaikouskaya.dto.AdditionalInfoDto;
import by.eslaikouskaya.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdditionalInfoController {
	@Autowired
	CityService service;

	@GetMapping("/info")
	public List<AdditionalInfoDto> getInfos (@RequestParam int maxCount) {
		if (maxCount < 1) throw new IllegalArgumentException();
		return service.getAllInfos(maxCount);
	}


	@GetMapping("/info/{infoId}")
	public AdditionalInfoDto getInfo(@PathVariable("infoId") int infoId) {
		return service.getInfoById(infoId);
	}

	@PostMapping("/info")
	public void createNewInfo(@RequestBody AdditionalInfoCmd newInfoCmd) {
		service.createNewInfo(newInfoCmd);
	}

	@PutMapping("/info")
	public void updateInfo(
	                       @RequestBody AdditionalInfoCmd infoCmd) {
		service.updateInfo(infoCmd);
	}

	@DeleteMapping("/info/{id}")
	public void deleteInfo(@PathVariable int id) {
		service.deleteInfo(id);
	}

}
