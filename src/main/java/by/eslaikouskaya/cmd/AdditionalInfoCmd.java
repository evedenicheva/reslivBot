package by.eslaikouskaya.cmd;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AdditionalInfoCmd {

	private Long id;
	private Long cityId;
	private String info;

}