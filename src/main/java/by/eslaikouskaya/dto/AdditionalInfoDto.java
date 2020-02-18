package by.eslaikouskaya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AdditionalInfoDto {

	private Long id;
	private Long cityId;
	private String info;

}