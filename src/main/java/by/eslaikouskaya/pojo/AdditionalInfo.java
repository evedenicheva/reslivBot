package by.eslaikouskaya.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "AdditionalInfo")
@NoArgsConstructor
public class AdditionalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cityId;
	private String info;

}
